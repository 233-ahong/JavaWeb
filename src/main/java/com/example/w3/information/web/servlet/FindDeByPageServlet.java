package com.example.w3.information.web.servlet;

import com.example.w3.information.department.Department;
import com.example.w3.information.department.PageBean;
import com.example.w3.information.service.IDeService;
import com.example.w3.information.service.impl.DeServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "FindDeByPageServlet", value = "/FindDeByPageServlet")
public class FindDeByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }
        Map<String, String[]> condition = request.getParameterMap();
        IDeService service = new DeServiceImpl();
        PageBean<Department> pb = service.findDeByPage(currentPage, rows, condition);
        request.setAttribute("pb", pb);
        request.setAttribute("condition",condition);
        request.getRequestDispatcher("/Information.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
