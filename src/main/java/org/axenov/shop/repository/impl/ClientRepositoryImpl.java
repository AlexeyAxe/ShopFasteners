package org.axenov.shop.repository.impl;

import org.axenov.shop.db.ConnectionManager;
import org.axenov.shop.model.Client;
import org.axenov.shop.repository.ClientRepository;
import org.axenov.shop.repository.mapper.impl.ClientMapperImpl;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryImpl implements ClientRepository {
    private final ConnectionManager connectionManager;
    private ClientMapperImpl clientMapper;
    private static final String FIND_BY_ID = "SELECT * FROM client WHERE id_user = ?";
    private static final String FIND_ALL = "SELECT * FROM client";
    private static final String DELETE_BY_ID = "DELETE * FROM client WHERE id_user = ?";
    private static final String SAVE = "INSERT INTO client(id_user,first_name,last_name,email) VALUES = (?,?,?,?)";

    public ClientRepositoryImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
        clientMapper =new ClientMapperImpl();
    }

    @Override
    public Client findById(Long id) {
        try (PreparedStatement preparedStatement = connectionManager
                .getConnection().prepareStatement(FIND_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
            return clientMapper.mapToUser(resultSet);
            }
            return null;
        } catch (SQLException | IOException e) {
            throw new RuntimeException("Not found user by ID", e);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try (PreparedStatement preparedStatement = connectionManager
                .getConnection().prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException | IOException e) {
            throw new RuntimeException("Not delete user by ID", e);
        }
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        try (PreparedStatement preparedStatement = connectionManager
                .getConnection().prepareStatement(FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 clients.add(clientMapper.mapToUser(resultSet));
            }
            return clients;
        } catch (SQLException | IOException e) {
            throw new RuntimeException("Not found all user by ID", e);
        }
    }

    @Override
    public boolean save(Client client) {
        try (PreparedStatement preparedStatement = connectionManager
                .getConnection().prepareStatement(SAVE)) {
            preparedStatement.setLong(1, client.getIdUser());
            preparedStatement.setString(2, client.getFirstName());
            preparedStatement.setString(3, client.getLastName());
            preparedStatement.setString(4, client.getEmail());
            int i = preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                clientMapper.mapToUser(resultSet);
            return i>0;
            }
        }
        catch (SQLException | IOException e) {
            throw new RuntimeException("Not save user", e);
        }
        return false;
    }
}
