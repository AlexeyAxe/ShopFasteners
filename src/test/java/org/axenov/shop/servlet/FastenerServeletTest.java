package org.axenov.shop.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.axenov.shop.model.Fastener;
import org.axenov.shop.service.FastenerService;
import org.axenov.shop.servlet.dto.FastenerDTO;
import org.axenov.shop.servlet.mapper.FastenerMapperDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

 class FastenerServeletTest {
    private FastenerServlet fastenerServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private FastenerService service;
    private FastenerMapperDTO dtomapper;

    @BeforeEach
    public void setUp() {
        fastenerServlet = new FastenerServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        service = mock(FastenerService.class);
        dtomapper = mock(FastenerMapperDTO.class);

        fastenerServlet.init(service, dtomapper);
    }

    @Test
     void doGetTest() throws Exception {
        when(request.getParameter("id")).thenReturn("1");

        Fastener fastener = new Fastener();
        fastener.setIdFastener(1L);
        fastener.setNameFastener("Test");

        FastenerDTO fastenerDTO = new FastenerDTO();
        fastenerDTO.setIdFastener(1L);
        fastenerDTO.setNameFastener("Test");

        when(service.findById(1L)).thenReturn(fastener);
        when(dtomapper.toFastenerDTO(fastener)).thenReturn(fastenerDTO);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);

        fastenerServlet.doGet(request, response);

        writer.flush();
        assertTrue(stringWriter.toString().contains("Fastener Details"));
        assertTrue(stringWriter.toString().contains("ID: 1"));
        assertTrue(stringWriter.toString().contains("Name: Test"));
    }
    @Test
     void doPostTest() throws Exception {
        when(request.getParameter("idFastener")).thenReturn("1");
        when(request.getParameter("nameFastener")).thenReturn("Test");

        Fastener fastener = new Fastener();
        fastener.setIdFastener(1L);
        fastener.setNameFastener("Test");

        FastenerDTO fastenerDTO = new FastenerDTO();
        fastenerDTO.setIdFastener(1L);
        fastenerDTO.setNameFastener("Test");

        when(dtomapper.toFastener(fastenerDTO)).thenReturn(fastener);
        when(service.save(fastener)).thenReturn(true);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);

        fastenerServlet.doPost(request, response);

        writer.flush();
        assertTrue(stringWriter.toString().contains("Fastener saved"));
    }
}
