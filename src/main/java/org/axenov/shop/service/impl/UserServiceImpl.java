package org.axenov.shop.service.impl;

import org.axenov.shop.db.ConnectionManager;
import org.axenov.shop.db.ConnectionManagerImpl;
import org.axenov.shop.model.User;
import org.axenov.shop.repository.impl.UserRepositoryImpl;
import org.axenov.shop.service.UserService;

import java.io.IOException;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserRepositoryImpl userRepository;
    private final ConnectionManager connectionManager;

    public UserServiceImpl()  {
        connectionManager= new ConnectionManagerImpl();
        userRepository=new UserRepositoryImpl(connectionManager.getConnection());
    }

    public UserServiceImpl(UserRepositoryImpl userRepository, ConnectionManager connectionManager) {
        this.connectionManager=connectionManager;
        this.userRepository = userRepository;
    }

    @Override
    public boolean save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }
}
