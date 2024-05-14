package org.axenov.shop.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.axenov.shop.servlet.dto.UserDTO;
import org.axenov.shop.model.User;
import org.axenov.shop.service.UserService;
import org.axenov.shop.service.impl.UserServiceImpl;
import org.axenov.shop.servlet.mapper.Impl.UserMapperDTOImpl;
import org.axenov.shop.servlet.mapper.UserMapperDTO;
import java.io.IOException;
import java.io.PrintWriter;


public class UserServlet extends HttpServlet {
    private UserService service;
    private UserMapperDTO dtomapper;

    @Override
    public void init(){
        this.service=new UserServiceImpl();
        this.dtomapper= new UserMapperDTOImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        long id = Long.parseLong(req.getParameter("id"));
        User user = service.findById(id);
        UserDTO userDTO = dtomapper.toUserDTO(user);
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        if (user != null) {
            out.println("<h1>User Details</h1>");
            out.println("<p>ID: " + userDTO.getIdUser() + "</p>");
            out.println("<p>First Name: " + userDTO.getFirstName() + "</p>");
            out.println("<p>Last Name: " + userDTO.getLastName() + "</p>");
            out.println("<p>Email: " + userDTO.getEmail() + "</p>");
        } else {
            out.println("<h1>User not found!</h1>");
        }
        out.println("</body></html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        long idUser = Long.parseLong(req.getParameter("idUser"));
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        UserDTO userDTO = new UserDTO(idUser, firstName,lastName, email);
        User user = dtomapper.toUser(userDTO);
        boolean save = service.save(user);

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        if (save) {
            out.println("<h1>User saved</h1>");
        } else {
            out.println("<h1>User didn't save!</h1>");
        }
        out.println("</body></html>");
        out.close();
    }
}
