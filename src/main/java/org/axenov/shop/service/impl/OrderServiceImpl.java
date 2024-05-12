package org.axenov.shop.service.impl;

import org.axenov.shop.db.ConnectionManager;
import org.axenov.shop.db.ConnectionManagerImpl;
import org.axenov.shop.model.Order;
import org.axenov.shop.repository.impl.OrderRepositoryImpl;
import org.axenov.shop.service.OrderService;

import java.io.IOException;
import java.sql.SQLException;

public class OrderServiceImpl implements OrderService {
    OrderRepositoryImpl orderRepository;
    private final ConnectionManager connectionManager;

    public OrderServiceImpl()  {
        connectionManager= new ConnectionManagerImpl();
        orderRepository=new OrderRepositoryImpl(connectionManager.getConnection());
    }

    public OrderServiceImpl(OrderRepositoryImpl orderRepository, ConnectionManager connectionManager) {
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
