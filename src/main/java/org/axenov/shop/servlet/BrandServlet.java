package org.axenov.shop.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.axenov.shop.model.Brand;
import org.axenov.shop.service.BrandService;
import org.axenov.shop.service.impl.BrandServiceImpl;
import org.axenov.shop.servlet.dto.BrandDTO;
import org.axenov.shop.servlet.mapper.BrandMapperDTO;
import org.axenov.shop.servlet.mapper.Impl.BrandMapperDTOImpl;

import java.io.IOException;
import java.io.PrintWriter;


public class BrandServlet extends HttpServlet {
    private final BrandService service;
    private final BrandMapperDTO dtomapper;

    public BrandServlet(BrandService brandService, BrandMapperDTO brandMapperDTO) {
        this.service=brandService;
        this.dtomapper= brandMapperDTO;
    }

    public BrandServlet() {
        service=new BrandServiceImpl();
        dtomapper=new BrandMapperDTOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        long id = Long.parseLong(req.getParameter("id"));
        Brand brand = service.findById(id);
        BrandDTO brandDTO = dtomapper.toBrandDTO(brand);
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        if (brand != null) {
            out.println("<h1>Brand Details</h1>");
            out.println("<p>ID: " + brandDTO.getIdBrand() + "</p>");
            out.println("<p>Name: " + brandDTO.getNameBrand() + "</p>");
        } else {
            out.println("<h1>Brand not found!</h1>");
        }
        out.println("</body></html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        long idBrand = Long.parseLong(req.getParameter("idBrand"));
        String nameBrand = req.getParameter("nameBrand");
        BrandDTO brandDTO = new BrandDTO(idBrand, nameBrand);
        Brand brand = dtomapper.toBrand(brandDTO);
        boolean save = service.save(brand);

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        if (save) {
            out.println("<h1>Brand saved</h1>");
        } else {
            out.println("<h1>Brand didn't save!</h1>");
        }
        out.println("</body></html>");
        out.close();
    }
}
