package org.example.shop.repository.mapper;

import org.example.shop.model.User;

import java.sql.ResultSet;

public interface UserMapper {
    User map(ResultSet resultSet);
}
