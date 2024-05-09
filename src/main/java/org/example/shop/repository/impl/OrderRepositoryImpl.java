package org.example.shop.repository.impl;

import org.example.shop.model.Order;
import org.example.shop.repository.OrderRepository;

import java.time.LocalDate;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {
    private final Connection connection;
    private static final String FIND_BY_ID = "SELECT * FROM order WHERE id_order = ?";
    private static final String FIND_ALL = "SELECT * FROM order";
    private static final String DELETE_BY_ID = "DELETE * FROM order WHERE id_order = ?";
    private static final String SAVE = "INSERT INTO order (id_order,date_order,status,id_user,id_fastener,quantity) VALUES = (?,?,?,?,?,?)";

    public OrderRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Order> findById(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Order order = new Order();
                order.setDateOrder(resultSet.getDate("date_order").toLocalDate());
                order.setIdOrder(resultSet.getLong("id_order"));
                order.setStatus(resultSet.getString("status"));
                order.setIdUser(resultSet.getLong("id_user"));
                order.setIdFastener(resultSet.getLong("id_fastener"));
                order.setQuantity(resultSet.getInt("quantity"));
                return Optional.of(order);
            }
            return Optional.empty();
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
                Order order = new Order();
                order.setIdOrder(resultSet.getLong("id_order"));
                order.setIdUser(resultSet.getLong("id_user"));
                order.setStatus(resultSet.getString("status"));
                order.setDateOrder(resultSet.getDate("date_order").toLocalDate());
                order.setIdFastener(resultSet.getLong("id_fastener"));
                order.setQuantity(resultSet.getInt("quantity"));
                orders.add(order);
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
