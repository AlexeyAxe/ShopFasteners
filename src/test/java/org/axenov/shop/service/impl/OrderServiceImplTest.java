package org.axenov.shop.service.impl;

import org.axenov.shop.model.Order;
import org.axenov.shop.repository.impl.OrderRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
 class OrderServiceImplTest {
    @Mock
    private OrderRepositoryImpl orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    void testSave() {
        Order order = new Order();
        order.setStatus("Test Status Order");
        order.setDateOrder(LocalDate.of(2024,5,15));
        order.setIdOrder(1L);
        order.setIdFastener(3L);
        order.setIdFastener(2L);
        order.setQuantity(100);
        boolean saved = orderService.save(order);

        verify(orderRepository).save(order);

        assertEquals(true, saved);
    }

    @Test
    void testFindById() {
        Order order = new Order();
        order.setStatus("Test Status Order");
        order.setDateOrder(LocalDate.of(2024,5,15));
        order.setIdOrder(1L);
        order.setIdFastener(3L);
        order.setIdFastener(2L);
        order.setQuantity(100);

        when(orderRepository.findById(1L)).thenReturn(order);

        Order foundOrder = orderService.findById(1L);

        verify(orderRepository).findById(1L);

        assertEquals(order, foundOrder);
    }
}
