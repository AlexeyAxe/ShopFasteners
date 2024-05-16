package org.axenov.shop.repository.impl;

import org.axenov.shop.db.ConnectionManager;
import org.axenov.shop.model.Order;
import org.axenov.shop.repository.OrderRepository;
import org.axenov.shop.repository.mapper.impl.OrderMapperImpl;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private final ConnectionManager connectionManager;
    private OrderMapperImpl orderMapper;
    private static final String FIND_BY_ID = "SELECT * FROM order WHERE id_order = ?";
    private static final String FIND_ALL = "SELECT * FROM order";
    private static final String DELETE_BY_ID = "DELETE * FROM order WHERE id_order = ?";
    private static final String SAVE = "INSERT INTO order (id_order,date_order,status,id_user,id_fastener,quantity) VALUES (?,?,?,?,?,?)";

    public OrderRepositoryImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
        orderMapper =new OrderMapperImpl();

    }

    @Override
    public Order findById(Long id) {
        try (PreparedStatement preparedStatement = connectionManager
                .getConnection().prepareStatement(FIND_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
            return orderMapper.mapToOrder(resultSet);
            }
            return null;
        } catch (SQLException | IOException e) {
            throw new RuntimeException("Not found order by ID", e);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try (PreparedStatement preparedStatement = connectionManager
                .getConnection().prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException | IOException e) {
            throw new RuntimeException("Not delete order", e);
        }
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        try (PreparedStatement preparedStatement = connectionManager
                .getConnection().prepareStatement(FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(orderMapper.mapToOrder(resultSet));
            }
            return orders;
        } catch (SQLException | IOException e) {
            throw new RuntimeException("Not found all order by ID", e);
        }
    }

    @Override
    public boolean save(Order order) {
        boolean result;
        try (PreparedStatement preparedStatement = connectionManager
                .getConnection().prepareStatement(SAVE)) {
            preparedStatement.setLong(1, order.getIdOrder());
            preparedStatement.setDate(2, Date.valueOf(order.getDateOrder()));
            preparedStatement.setString(3, order.getStatus());
            preparedStatement.setLong(4, order.getIdUser());
            preparedStatement.setLong(5, order.getIdFastener());
            preparedStatement.setInt(6, order.getQuantity());
            result = preparedStatement.executeUpdate()>0;
          } catch (SQLException | IOException e) {
            throw new RuntimeException("Not save order", e);
        }
        return result;
    }
}
