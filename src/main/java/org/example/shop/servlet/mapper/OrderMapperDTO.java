package org.example.shop.servlet.mapper;

import org.example.shop.model.Order;
import org.example.shop.servlet.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapperDTO {
    OrderMapperDTO INSTANCE = Mappers.getMapper(OrderMapperDTO.class);

    OrderDTO toOrderDTO(Order order);
    Order toOrder(OrderDTO orderDTO);

}
