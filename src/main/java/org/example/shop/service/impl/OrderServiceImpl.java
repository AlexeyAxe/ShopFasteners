package org.example.shop.service.impl;

import org.example.shop.model.Order;
import org.example.shop.repository.impl.OrderRepositoryImpl;
import org.example.shop.service.OrderService;

public class OrderServiceImpl implements OrderService {
    OrderRepositoryImpl orderRepository;

    @Override
    public boolean save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).get();
    }
}
