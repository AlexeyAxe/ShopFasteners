package org.example.shop.repository.mapper;

import org.example.shop.model.Order;

import java.sql.ResultSet;

public interface OrderMapper {
    Order mapToOrder(ResultSet resultSet);
}
