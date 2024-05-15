package org.axenov.shop.servlet.mapper;

import org.axenov.shop.model.Client;
import org.axenov.shop.model.Order;
import org.axenov.shop.servlet.dto.ClientDTO;
import org.axenov.shop.servlet.dto.OrderDTO;
import org.axenov.shop.servlet.mapper.Impl.ClientMapperDTOImpl;
import org.axenov.shop.servlet.mapper.Impl.OrderMapperDTOImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class OrderMapperDTOTest {

    @Test
    void testToOrderDTO() {
        Order order = new Order(1L, LocalDate.of(2024,12,16),"paid",2L,1L,55);
        OrderMapperDTO orderMapperDTO=new OrderMapperDTOImpl();
        OrderDTO orderDTO = orderMapperDTO.toOrderDTO(order);

        assertEquals(order.getIdOrder(), orderDTO.getIdOrder());
        assertEquals(order.getDateOrder(), orderDTO.getDateOrder());
        assertEquals(order.getStatus(), orderDTO.getStatus());
        assertEquals(order.getIdUser(), orderDTO.getIdUser());
        assertEquals(order.getIdFastener(), orderDTO.getIdFastener());
        assertEquals(order.getQuantity(), orderDTO.getQuantity());
    }

    @Test
    void testToOrder() {

        OrderDTO orderDTO = new OrderDTO(1L, LocalDate.of(2024,12,16),"paid",2L,1L,55);

        OrderMapperDTO orderMapperDTO=new OrderMapperDTOImpl();
        Order order = orderMapperDTO.toOrder(orderDTO);
        assertEquals(order.getIdOrder(), orderDTO.getIdOrder());
        assertEquals(order.getDateOrder(), orderDTO.getDateOrder());
        assertEquals(order.getStatus(), orderDTO.getStatus());
        assertEquals(order.getIdUser(), orderDTO.getIdUser());
        assertEquals(order.getIdFastener(), orderDTO.getIdFastener());
        assertEquals(order.getQuantity(), orderDTO.getQuantity());
    }
}
