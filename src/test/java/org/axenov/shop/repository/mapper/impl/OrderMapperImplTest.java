package org.axenov.shop.repository.mapper.impl;

import org.axenov.shop.model.Order;
import org.axenov.shop.repository.mapper.OrderMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderMapperImplTest {

    @Mock
    private ResultSet resultSet;

    private OrderMapper orderMapper;

    @BeforeEach
    public void setUp() throws SQLException{
        orderMapper =new OrderMapperImpl();
        when(resultSet.getString("status")).thenReturn("Test Status");
        when(resultSet.getLong("id_order")).thenReturn(1L);
        when(resultSet.getLong("id_user")).thenReturn(2L);
        when(resultSet.getLong("id_fastener")).thenReturn(3L);
        when(resultSet.getDate("date_order")).thenReturn(Date.valueOf("2024-05-13"));
        when(resultSet.getInt("quantity")).thenReturn(100);
    }
    @Test
     void mapToOrderTest() throws SQLException{
        Order order=orderMapper.mapToOrder(resultSet);
        verify(resultSet).getString("status");
        verify(resultSet).getLong("id_order");
        verify(resultSet).getDate("date_order");
        verify(resultSet).getLong("id_user");
        verify(resultSet).getInt("quantity");
        verify(resultSet).getLong("id_fastener");

        assertEquals("Test Status", order.getStatus());
        assertEquals(1L, order.getIdOrder());
        assertEquals(2L, order.getIdUser());
        assertEquals(3L, order.getIdFastener());
        assertEquals(LocalDate.of(2024,5,13), order.getDateOrder());
        assertEquals(100, order.getQuantity());

    }
}

