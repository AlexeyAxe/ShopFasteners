package org.axenov.shop.servlet.mapper;

import org.axenov.shop.model.Order;
import org.axenov.shop.servlet.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface OrderMapperDTO {

    OrderDTO toOrderDTO(Order order);

    Order toOrder(OrderDTO orderDTO);

}
