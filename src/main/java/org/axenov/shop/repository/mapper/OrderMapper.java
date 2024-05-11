package org.axenov.shop.repository.mapper;

import org.axenov.shop.model.Order;

import java.sql.ResultSet;

public interface OrderMapper {
    Order mapToOrder(ResultSet resultSet);
}
