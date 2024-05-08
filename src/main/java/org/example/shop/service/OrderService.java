package org.example.shop.service;

import org.example.shop.model.Order;

import java.util.UUID;

public interface OrderService {
    boolean save (Order order);

    Order findById(Long id);
}
