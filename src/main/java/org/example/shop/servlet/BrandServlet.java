package org.example.shop.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.shop.model.Brand;
import org.example.shop.service.BrandService;
import org.example.shop.service.impl.BrandServiceImpl;
import org.example.shop.servlet.dto.BrandDTO;
import org.example.shop.servlet.mapper.BrandMapperDTO;

import java.io.IOException;
import java.io.PrintWriter;


public class BrandServlet extends HttpServlet {
    private BrandService service;
    private BrandMapperDTO dtomapper;

    @Override
    public void init(){
        this.service=new BrandServiceImpl();
        this.dtomapper= BrandMapperDTO.INSTANCE;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        Long id = Long.valueOf(req.getParameter("id"));
        Brand brand = service.findById(id);
        BrandDTO brandDTO = dtomapper.toBrandDTO(brand);
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        if (brand != null) {
            out.println("<h1>Brand Details</h1>");
            out.println("<p>ID: " + brandDTO.getIdBrand() + "</p>");
            out.println("<p>Name: " + brandDTO.getBrandName() + "</p>");
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
        Long idBrand = Long.valueOf(req.getParameter("idBrand"));
        String brandName = req.getParameter("brandName");
        BrandDTO brandDTO = new BrandDTO(idBrand, brandName);
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
