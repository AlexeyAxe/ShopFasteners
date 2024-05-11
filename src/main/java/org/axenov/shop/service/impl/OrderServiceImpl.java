package org.axenov.shop.service.impl;

import org.axenov.shop.model.Order;
import org.axenov.shop.repository.impl.OrderRepositoryImpl;
import org.axenov.shop.service.OrderService;

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
