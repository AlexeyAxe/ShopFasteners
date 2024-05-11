package org.axenov.shop.servlet.mapper;

import org.axenov.shop.model.Order;
import org.axenov.shop.servlet.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapperDTO {
    OrderMapperDTO INSTANCE = Mappers.getMapper(OrderMapperDTO.class);

    OrderDTO toOrderDTO(Order order);
    Order toOrder(OrderDTO orderDTO);

}
