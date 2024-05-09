package org.example.shop.service.impl;

import org.example.shop.model.User;
import org.example.shop.repository.impl.UserRepositoryImpl;
import org.example.shop.service.UserService;

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
