package com.example.w3.information.web.servlet;

import com.example.w3.information.department.Department;
import com.example.w3.information.service.DeService;
import com.example.w3.information.service.impl.DeServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "AddDeServlet", value = "/AddDeServlet")
public class AddDeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        Department department = new Department();
        try {
            BeanUtils.populate(department, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        DeService deService = new DeServiceImpl();
        deService.addDe(department);
        response.sendRedirect(request.getContextPath() + "/DeListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
