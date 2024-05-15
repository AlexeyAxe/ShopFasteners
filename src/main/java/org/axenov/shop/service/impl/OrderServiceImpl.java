package org.axenov.shop.service.impl;

import org.axenov.shop.db.ConnectionManager;
import org.axenov.shop.db.ConnectionManagerImpl;
import org.axenov.shop.model.Order;
import org.axenov.shop.repository.OrderRepository;
import org.axenov.shop.repository.impl.OrderRepositoryImpl;
import org.axenov.shop.service.OrderService;

import java.io.IOException;
import java.sql.SQLException;

public class OrderServiceImpl implements OrderService {
    OrderRepositoryImpl orderRepository;
    private final ConnectionManagerImpl connectionManager;

    public OrderServiceImpl()  {
        connectionManager= new ConnectionManagerImpl();
        orderRepository=new OrderRepositoryImpl(connectionManager);
    }

    public OrderServiceImpl(OrderRepositoryImpl orderRepository, ConnectionManagerImpl connectionManager) {
        this.connectionManager=connectionManager;
        this.orderRepository = orderRepository;
    }

    @Override
    public boolean save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id);
    }
}
