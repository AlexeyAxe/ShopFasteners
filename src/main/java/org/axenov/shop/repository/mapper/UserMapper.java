package org.axenov.shop.repository.mapper;

import org.axenov.shop.model.User;

import java.sql.ResultSet;

public interface UserMapper {
    User mapToUser(ResultSet resultSet);
}
