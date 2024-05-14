package org.axenov.shop.servlet.mapper.Impl;

import org.axenov.shop.model.Order;
import org.axenov.shop.servlet.dto.OrderDTO;
import org.axenov.shop.servlet.mapper.OrderMapperDTO;

public class OrderMapperDTOImpl implements OrderMapperDTO {
    @Override
    public OrderDTO toOrderDTO(Order order) {
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setIdFastener(order.getIdFastener());
        orderDTO.setDateOrder(order.getDateOrder());
        orderDTO.setIdOrder(order.getIdOrder());
        orderDTO.setIdUser(order.getIdUser());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setQuantity(order.getQuantity());
        return orderDTO;
    }

    @Override
    public Order toOrder(OrderDTO orderDTO) {
        Order order=new Order();
        order.setIdOrder(orderDTO.getIdOrder());
        order.setDateOrder(orderDTO.getDateOrder());
        order.setIdFastener(orderDTO.getIdFastener());
        order.setIdUser(orderDTO.getIdUser());
        order.setStatus(orderDTO.getStatus());
        order.setQuantity(orderDTO.getQuantity());
        return order;
    }
}
