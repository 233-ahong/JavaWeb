package com.example.w3.information.web.servlet;

import com.example.w3.information.department.Department;
import com.example.w3.information.service.IDeService;
import com.example.w3.information.service.impl.DeServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "UpDeServlet", value = "/UpDeServlet")
public class UpDeServlet extends HttpServlet {
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
        IDeService service = new DeServiceImpl();
        service.upData(department);
        response.sendRedirect(request.getContextPath() + "/FindDeByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
