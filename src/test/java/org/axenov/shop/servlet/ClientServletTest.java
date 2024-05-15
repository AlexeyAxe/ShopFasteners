package org.axenov.shop.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.axenov.shop.model.Client;
import org.axenov.shop.service.ClientService;
import org.axenov.shop.servlet.dto.ClientDTO;
import org.axenov.shop.servlet.mapper.ClientMapperDTO;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientServletTest {

    private ClientServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private ClientService service;
    private ClientMapperDTO dtomapper;
    private PrintWriter writer;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() throws Exception {
        servlet = new ClientServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        service = mock(ClientService.class);
        dtomapper = mock(ClientMapperDTO.class);
        servlet.service = service;
        servlet.dtomapper = dtomapper;

        outputStream = new ByteArrayOutputStream();
        writer = new PrintWriter(outputStream);
        when(response.getWriter()).thenReturn(writer);
    }

    @Test
    public void testDoGet_ClientExists() throws Exception {
        when(request.getParameter("id")).thenReturn("1");
        Client client = new Client();
        client.setIdUser(1L);
        when(service.findById(1L)).thenReturn(client);

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setIdUser(1L);
        when(dtomapper.toClientDTO(client)).thenReturn(clientDTO);

        servlet.doGet(request, response);

        writer.flush();
        String result = outputStream.toString();
        assertTrue(result.contains("User Details"));
        assertTrue(result.contains("ID: 1"));
    }

    @Test
    public void testDoGet_ClientNotFound() throws Exception {
        when(request.getParameter("id")).thenReturn("1");
        when(service.findById(1L)).thenReturn(null);

        servlet.doGet(request, response);

        writer.flush();
        String result = outputStream.toString();
        assertTrue(result.contains("User not found!"));
    }
    @Test
    public void testDoPost_UserSaved() throws Exception {
        when(request.getParameter("idUser")).thenReturn("1");
        when(request.getParameter("firstName")).thenReturn("John");
        when(request.getParameter("lastName")).thenReturn("Doe");
        when(request.getParameter("email")).thenReturn("john.doe@example.com");

        ClientDTO clientDTO = new ClientDTO(1L, "John", "Doe", "john.doe@example.com");
        Client client = new Client();
        when(dtomapper.toClient(clientDTO)).thenReturn(client);
        when(service.save(client)).thenReturn(true);

        servlet.doPost(request, response);

        writer.flush();
        String result = outputStream.toString();
        assertTrue(result.contains("User saved"));
    }

    @Test
    public void testDoPost_UserNotSaved() throws Exception {
        when(request.getParameter("idUser")).thenReturn("1");
        when(request.getParameter("firstName")).thenReturn("Dima");
        when(request.getParameter("lastName")).thenReturn("Grigorev");
        when(request.getParameter("email")).thenReturn("dima@cor.com");

        ClientDTO clientDTO = new ClientDTO(1L, "Dima", "Grigorev", "john.doe@cor.com");
        Client client = new Client();
        when(dtomapper.toClient(clientDTO)).thenReturn(client);
        when(service.save(client)).thenReturn(false);

        servlet.doPost(request, response);

        writer.flush();
        String result = outputStream.toString();
        assertTrue(result.contains("User didn't save!"));
    }
}
