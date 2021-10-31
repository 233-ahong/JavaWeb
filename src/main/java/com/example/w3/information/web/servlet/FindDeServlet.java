package com.example.w3.information.web.servlet;

import com.example.w3.information.department.Department;
import com.example.w3.information.service.DeService;
import com.example.w3.information.service.impl.DeServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "FindDeServlet", value = "/FindDeServlet")
public class FindDeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("did");
        if (id == null||"".equals(id)) {
            request.getRequestDispatcher("/FindDeByPageServlet").forward(request,response);
        }
        DeService service = new DeServiceImpl();
        Department de = service.findDe(id);
        request.setAttribute("de", de);
        request.getRequestDispatcher("/UpData.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
