package org.example.shop.repository.mapper.impl;

import org.example.shop.model.User;
import org.example.shop.repository.mapper.UserMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapperImpl implements UserMapper {
    @Override
    public User mapToUser(ResultSet resultSet) {
        try {
            User user = new User();
            user.setIdUser(resultSet.getLong("id_user"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setEmail(resultSet.getString("email"));
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
