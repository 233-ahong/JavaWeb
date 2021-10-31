package com.example.w3.information.web.servlet;

import com.example.w3.information.service.DeService;
import com.example.w3.information.service.impl.DeServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DelDeServlet", value = "/DelDeServlet")
public class DelDeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] dids = request.getParameterValues("did");
        DeService service = new DeServiceImpl();
        service.delDeList(dids);
        response.sendRedirect(request.getContextPath() + "/DeListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
