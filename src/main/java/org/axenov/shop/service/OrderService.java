package org.axenov.shop.service;

import org.axenov.shop.model.Order;

public interface OrderService {
    boolean save (Order order);

    Order findById(Long id);
}
