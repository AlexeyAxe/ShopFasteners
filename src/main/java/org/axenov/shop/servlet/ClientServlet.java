package org.axenov.shop.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.axenov.shop.model.Client;
import org.axenov.shop.servlet.dto.ClientDTO;
import org.axenov.shop.service.ClientService;
import org.axenov.shop.servlet.mapper.ClientMapperDTO;

import java.io.IOException;
import java.io.PrintWriter;


public class ClientServlet extends HttpServlet {
    ClientService service;
    ClientMapperDTO dtomapper;

    public void init(ClientService service, ClientMapperDTO mapperDTO) {
        this.service = service;
        this.dtomapper = mapperDTO;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        long id = Long.parseLong(req.getParameter("id"));
        Client client = service.findById(id);
        ClientDTO clientDTO = dtomapper.toClientDTO(client);
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        if (client != null) {
            out.println("<h1>User Details</h1>");
            out.println("<p>ID: " + clientDTO.getIdUser() + "</p>");
            out.println("<p>First Name: " + clientDTO.getFirstName() + "</p>");
            out.println("<p>Last Name: " + clientDTO.getLastName() + "</p>");
            out.println("<p>Email: " + clientDTO.getEmail() + "</p>");
        } else {
            out.println("<h1>User not found!</h1>");
        }
        out.println("</body></html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        long idUser = Long.parseLong(req.getParameter("idUser"));
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        ClientDTO clientDTO = new ClientDTO(idUser, firstName, lastName, email);
        Client client = dtomapper.toClient(clientDTO);
        boolean save = service.save(client);

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
