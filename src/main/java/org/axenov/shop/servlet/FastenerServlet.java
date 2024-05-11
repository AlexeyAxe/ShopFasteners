package org.axenov.shop.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.axenov.shop.servlet.mapper.FastenerMapperDTO;
import org.axenov.shop.model.Fastener;
import org.axenov.shop.service.FastenerService;
import org.axenov.shop.service.impl.FastenerServiceImpl;
import org.axenov.shop.servlet.dto.FastenerDTO;

import java.io.IOException;
import java.io.PrintWriter;


public class FastenerServlet extends HttpServlet {
    private FastenerService service;
    private FastenerMapperDTO dtomapper;

    @Override
    public void init(){
        this.service=new FastenerServiceImpl();
        this.dtomapper= FastenerMapperDTO.INSTANCE;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        long id = Long.parseLong(req.getParameter("id"));
        Fastener fastener = service.findById(id);
        FastenerDTO fastenerDTO = dtomapper.toFastenerDTO(fastener);
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        if (fastener != null) {
            out.println("<h1>Fastener Details</h1>");
            out.println("<p>ID: " + fastenerDTO.getIdFastener() + "</p>");
            out.println("<p>Name: " + fastenerDTO.getNameFastener() + "</p>");
        } else {
            out.println("<h1>Fastener not found!</h1>");
        }
        out.println("</body></html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        long idFastener = Long.parseLong(req.getParameter("idFastener"));
        String nameFastener = req.getParameter("nameFastener");
        FastenerDTO fastenerDTO = new FastenerDTO(idFastener, nameFastener);
        Fastener fastener = dtomapper.toFastener(fastenerDTO);
        boolean save = service.save(fastener);

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        if (save) {
            out.println("<h1>Fastener saved</h1>");
        } else {
            out.println("<h1>Fastener didn't save!</h1>");
        }
        out.println("</body></html>");
        out.close();
    }
}
