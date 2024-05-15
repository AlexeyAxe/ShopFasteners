package org.axenov.shop.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.axenov.shop.model.Order;
import org.axenov.shop.service.OrderService;
import org.axenov.shop.servlet.dto.OrderDTO;
import org.axenov.shop.servlet.mapper.OrderMapperDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderServletTest {
    private OrderServlet orderServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private OrderService service;
    private OrderMapperDTO dtomapper;

    @BeforeEach
    public void setUp() {
        orderServlet = new OrderServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        service = mock(OrderService.class);
        dtomapper = mock(OrderMapperDTO.class);

        orderServlet.init(service, dtomapper);
    }

    @Test
    void doGetTest() throws Exception {
        when(request.getParameter("id")).thenReturn("1");

        Order order = new Order();

        OrderDTO orderDTO = new OrderDTO();

        when(service.findById(1L)).thenReturn(order);
        when(dtomapper.toOrderDTO(order)).thenReturn(orderDTO);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);

        orderServlet.doGet(request, response);

        writer.flush();
        assertTrue(stringWriter.toString().contains("Order Details"));
    }
    @Test
    void doPostTest() throws Exception {
        when(request.getParameter("idOrder")).thenReturn("1");
        when(request.getParameter("dateOrder")).thenReturn("2024-12-15");
        when(request.getParameter("status")).thenReturn("Test Status");
        when(request.getParameter("idUser")).thenReturn("2");
        when(request.getParameter("idFastener")).thenReturn("3");
        when(request.getParameter("quantity")).thenReturn("10");

        Order order = new Order();

        OrderDTO orderDTO = new OrderDTO();

        when(dtomapper.toOrder(orderDTO)).thenReturn(order);
        when(service.save(order)).thenReturn(true);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);

        orderServlet.doPost(request, response);

        writer.flush();
        assertTrue(stringWriter.toString().contains("Order saved"));
    }
}
