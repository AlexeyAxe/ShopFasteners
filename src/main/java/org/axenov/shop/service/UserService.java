package org.axenov.shop.service;

import org.axenov.shop.model.User;

public interface UserService {
    boolean save (User user);

    User findById(Long id);
}
