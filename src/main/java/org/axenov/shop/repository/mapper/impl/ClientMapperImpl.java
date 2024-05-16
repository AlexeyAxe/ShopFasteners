package org.axenov.shop.repository.mapper.impl;

import org.axenov.shop.model.Client;
import org.axenov.shop.repository.mapper.UserMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapperImpl implements UserMapper {
    @Override
    public Client mapToUser(ResultSet resultSet) {
        try {
            Client client = new Client();
            client.setIdUser(resultSet.getLong("id_user"));
            client.setFirstName(resultSet.getString("first_name"));
            client.setLastName(resultSet.getString("last_name"));
            client.setEmail(resultSet.getString("email"));
            return client;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
