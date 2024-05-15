package org.axenov.shop.repository.mapper;

import org.axenov.shop.model.Client;

import java.sql.ResultSet;

public interface UserMapper {
    Client mapToUser(ResultSet resultSet);
}
