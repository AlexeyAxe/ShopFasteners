package org.axenov.shop.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.axenov.shop.model.Client;
import org.axenov.shop.model.Fastener;
import org.axenov.shop.service.ClientService;
import org.axenov.shop.service.FastenerService;
import org.axenov.shop.servlet.dto.ClientDTO;
import org.axenov.shop.servlet.dto.FastenerDTO;
import org.axenov.shop.servlet.mapper.ClientMapperDTO;
import org.axenov.shop.servlet.mapper.FastenerMapperDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ClientServletTest {

    private ClientServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private ClientService service;
    private ClientMapperDTO dtomapper;


    @BeforeEach
    void setUp() {
        servlet = new ClientServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        service = mock(ClientService.class);
        dtomapper = mock(ClientMapperDTO.class);

        servlet.init(service, dtomapper);
    }

    @Test
    void doGetTest() throws Exception {
        when(request.getParameter("id")).thenReturn("1");

        Client client = new Client();
        client.setIdUser(1L);
        client.setFirstName("Leo");
        client.setLastName("Axe");
        client.setEmail("leo@axe.com");


        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setIdUser(1L);
        clientDTO.setFirstName("Leo");
        clientDTO.setLastName("Axe");
        clientDTO.setEmail("leo@axe.com");

        when(service.findById(1L)).thenReturn(client);
        when(dtomapper.toClientDTO(client)).thenReturn(clientDTO);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);

        servlet.doGet(request, response);

        writer.flush();
        Assertions.assertTrue(stringWriter.toString().contains("User Details"));
        Assertions.assertTrue(stringWriter.toString().contains("ID: 1"));
        Assertions.assertTrue(stringWriter.toString().contains("First Name: Leo"));
        Assertions.assertTrue(stringWriter.toString().contains("Last Name: Axe"));
        Assertions.assertTrue(stringWriter.toString().contains("Email: leo@axe.com"));

    }
    @Test
    void doPostTest() throws Exception {
        when(request.getParameter("idUser")).thenReturn("1");
        when(request.getParameter("firstName")).thenReturn("Test");

        Client client = new Client();
        client.setIdUser(1L);
        client.setFirstName("Brad");
        client.setLastName("Pitt");
        client.setEmail("bradpitt@mail.ru");

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setIdUser(1L);
        clientDTO.setFirstName("Brad");
        clientDTO.setLastName("Pitt");
        clientDTO.setEmail("bradpitt@mail.ru");

        when(dtomapper.toClient(clientDTO)).thenReturn(client);
        when(service.save(client)).thenReturn(true);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);

        servlet.doPost(request, response);

        writer.flush();
        Assertions.assertTrue(stringWriter.toString().contains("Client saved"));
    }
}
