package org.axenov.shop.service.impl;

import org.axenov.shop.model.User;
import org.axenov.shop.repository.impl.UserRepositoryImpl;
import org.axenov.shop.service.UserService;

public class UserServiceImpl implements UserService {
    private UserRepositoryImpl userRepository;

    @Override
    public boolean save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }
}
