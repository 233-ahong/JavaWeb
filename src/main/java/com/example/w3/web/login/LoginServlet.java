package com.example.w3.web.login;

import com.example.w3.web.bll.User;
import com.example.w3.web.bll.Userdao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        User loginuser = new User();
        try {
            BeanUtils.populate(loginuser, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        Userdao dao = new Userdao();
        User user = dao.Zhuce(loginuser);
        System.out.println(user);
        if (user != null) {
            request.getRequestDispatcher("/SuccessServlet").forward(request, response);
        } else {
            request.getRequestDispatcher("/FailServlet").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
