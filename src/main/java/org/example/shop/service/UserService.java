package org.example.shop.service;

import org.example.shop.model.User;

public interface UserService {
    boolean save (User user);

    User findById(Long id);
}
