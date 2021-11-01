package com.example.w3.information.web.servlet;

import com.example.w3.information.department.Department;
import com.example.w3.information.service.IDeService;
import com.example.w3.information.service.impl.DeServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeListServlet", value = "/DeListServlet")
public class DeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IDeService service = new DeServiceImpl();
        List<Department> departments = service.selectAll();
        request.setAttribute("departments", departments);
        request.getRequestDispatcher("/FindDeByPageServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
