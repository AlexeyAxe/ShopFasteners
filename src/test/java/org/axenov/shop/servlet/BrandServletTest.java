package org.axenov.shop.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.axenov.shop.model.Brand;
import org.axenov.shop.service.BrandService;
import org.axenov.shop.servlet.dto.BrandDTO;
import org.axenov.shop.servlet.mapper.BrandMapperDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

class BrandServletTest {
    private BrandServlet brandServlet;
    private BrandService brandService;
    private BrandMapperDTO brandMapperDTO;

    private HttpServletRequest request;
    private HttpServletResponse response;
    private StringWriter stringWriter;
    private PrintWriter printWriter;

    @BeforeEach
    void setUp() throws IOException {
        brandServlet = new BrandServlet();
        brandService = Mockito.mock(BrandService.class);
        brandMapperDTO = Mockito.mock(BrandMapperDTO.class);

        brandServlet.init();

        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);

        stringWriter = new StringWriter();
        printWriter = new PrintWriter(stringWriter);
        Mockito.when(response.getWriter()).thenReturn(printWriter);
    }

    @Test
    void doGet_whenBrandIsFound() throws ServletException, IOException {
        long id = 1L;
        Mockito.when(request.getParameter("id")).thenReturn(String.valueOf(id));
        Brand brand = new Brand(id, "Hilti");
        Mockito.when(brandService.findById(id)).thenReturn(brand);
        BrandDTO brandDTO = new BrandDTO(id, "Hilti");
        Mockito.when(brandMapperDTO.toBrandDTO(brand)).thenReturn(brandDTO);

        brandServlet.doGet(request, response);

        assertEquals("<h1>Brand Details</h1><p>ID: 1</p><p>Name: Hilti</p>", stringWriter.toString());
    }

    @Test
    void doGet_whenBrandIsNotFound() throws ServletException, IOException {
        long id = 1L;
        Mockito.when(request.getParameter("id")).thenReturn(String.valueOf(id));
        Mockito.when(brandService.findById(id)).thenReturn(null);

        brandServlet.doGet(request, response);

        assertEquals("<h1>Brand not found!</h1>", stringWriter.toString());
    }

    @Test
    void doPost_whenBrandIsSaved() throws ServletException, IOException {
        long id = 1L;
        String name = "Hilti";
        Mockito.when(request.getParameter("idBrand")).thenReturn(String.valueOf(id));
        Mockito.when(request.getParameter("nameBrand")).thenReturn(name);
        BrandDTO brandDTO = new BrandDTO(id, name);
        Brand brand = new Brand(id, name);
        Mockito.when(brandMapperDTO.toBrand(brandDTO)).thenReturn(brand);
        Mockito.when(brandService.save(brand)).thenReturn(true);

        brandServlet.doPost(request, response);

        assertEquals("<h1>Brand saved</h1>", stringWriter.toString());
    }

    @Test
    void doPost_whenBrandIsNotSaved() throws ServletException, IOException {
        long id = 1L;
        String name = "Hilti";
        Mockito.when(request.getParameter("idBrand")).thenReturn(String.valueOf(id));
        Mockito.when(request.getParameter("nameBrand")).thenReturn(name);
        BrandDTO brandDTO = new BrandDTO(id, name);
        Brand brand = new Brand(id, name);
        Mockito.when(brandMapperDTO.toBrand(brandDTO)).thenReturn(brand);
        Mockito.when(brandService.save(brand)).thenReturn(false);

        brandServlet.doPost(request, response);

        assertEquals("<h1>Brand didn't save!</h1>", stringWriter.toString());
    }
}