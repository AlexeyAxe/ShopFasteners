package org.axenov.shop.repository.impl;

import org.axenov.shop.model.Order;
import org.axenov.shop.repository.OrderRepository;
import org.axenov.shop.repository.mapper.impl.OrderMapperImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {
    private final Connection connection;
    private OrderMapperImpl orderMapper;
    private static final String FIND_BY_ID = "SELECT * FROM order WHERE id_order = ?";
    private static final String FIND_ALL = "SELECT * FROM order";
    private static final String DELETE_BY_ID = "DELETE * FROM order WHERE id_order = ?";
    private static final String SAVE = "INSERT INTO order (id_order,date_order,status,id_user,id_fastener,quantity) VALUES = (?,?,?,?,?,?)";

    public OrderRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Order findById(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
            return orderMapper.mapToOrder(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(orderMapper.mapToOrder(resultSet));
            }
            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean save(Order order) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SAVE)) {
            preparedStatement.setLong(1, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setDate(2, Date.valueOf(order.getDateOrder()));
            preparedStatement.setString(3, order.getStatus());
            preparedStatement.setLong(4, order.getIdUser());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
