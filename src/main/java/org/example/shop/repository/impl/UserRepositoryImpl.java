package org.example.shop.repository.impl;

import org.example.shop.model.User;
import org.example.shop.repository.UserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private final Connection connection;
    private static final String FIND_BY_ID = "SELECT * FROM user WHERE id_user = ?";
    private static final String FIND_ALL = "SELECT * FROM user";
    private static final String DELETE_BY_ID = "DELETE * FROM User WHERE id_user = ?";
    private static final String SAVE = "INSERT INTO user(id_user,first_name,last_name,email) VALUES = (?,?,?,?)";

    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public Optional<User> findById(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setIdUser(resultSet.getLong("id_user"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                return Optional.of(user);
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
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setIdUser(resultSet.getLong("id_user"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean save(User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SAVE)) {
            preparedStatement.setLong(1, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmail());
            return preparedStatement.executeUpdate()>0;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
