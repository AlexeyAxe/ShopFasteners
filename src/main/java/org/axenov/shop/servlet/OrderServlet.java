package org.axenov.shop.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.axenov.shop.servlet.mapper.Impl.OrderMapperDTOImpl;
import org.axenov.shop.servlet.mapper.OrderMapperDTO;
import org.axenov.shop.model.Order;
import org.axenov.shop.service.OrderService;
import org.axenov.shop.service.impl.OrderServiceImpl;
import org.axenov.shop.servlet.dto.OrderDTO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;


public class OrderServlet extends HttpServlet {
    private OrderService service;
    private OrderMapperDTO dtomapper;

    @Override
    public void init(){

        this.service=new OrderServiceImpl();

        this.dtomapper= new OrderMapperDTOImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        long id = Long.parseLong(req.getParameter("id"));
        Order order = service.findById(id);
        OrderDTO orderDTO = dtomapper.toOrderDTO(order);
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        if (order != null) {
            out.println("<h1>Order Details</h1>");
            out.println("<p>ID Order: " + orderDTO.getIdOrder() + "</p>");
            out.println("<p>Date Order: " + orderDTO.getDateOrder() + "</p>");
            out.println("<p>Status: " + orderDTO.getStatus() + "</p>");
            out.println("<p>ID User: " + orderDTO.getIdUser() + "</p>");
            out.println("<p>ID Fastener: " + orderDTO.getIdFastener() + "</p>");
            out.println("<p>Quantity: " + orderDTO.getQuantity() + "</p>");
        } else {
            out.println("<h1>Order not found!</h1>");
        }
        out.println("</body></html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        long idOrder = Long.parseLong(req.getParameter("idOrder"));
        String status = req.getParameter("status");
        LocalDate dateOrder= LocalDate.parse(req.getParameter("dateOrder"));
        long idUser= Long.parseLong(req.getParameter("idUser"));
        long idFastener= Long.parseLong(req.getParameter("idFastener"));
        int quantity= Integer.parseInt(req.getParameter("quantity"));
        OrderDTO orderDTO = new OrderDTO(idOrder,dateOrder,status, idUser, idFastener, quantity);
        Order order = dtomapper.toOrder(orderDTO);
        boolean save = service.save(order);

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        if (save) {
            out.println("<h1>Order saved</h1>");
        } else {
            out.println("<h1>Order didn't save!</h1>");
        }
        out.println("</body></html>");
        out.close();
    }
}
