package org.axenov.shop.repository.mapper.impl;

import org.axenov.shop.model.Order;
import org.axenov.shop.repository.mapper.OrderMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapperImpl implements OrderMapper {
    @Override
    public Order mapToOrder(ResultSet resultSet) {
        try {
        Order order = new Order();
        order.setIdOrder(resultSet.getLong("id_order"));
        order.setDateOrder(resultSet.getDate("date_order").toLocalDate());
        order.setStatus(resultSet.getString("status"));
        order.setIdUser(resultSet.getLong("id_user"));
        order.setIdFastener(resultSet.getLong("id_fastener"));
        order.setQuantity(resultSet.getInt("quantity"));
        return order;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
