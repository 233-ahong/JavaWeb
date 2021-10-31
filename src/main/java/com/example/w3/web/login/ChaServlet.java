package com.example.w3.web.login;

import com.example.w3.web.bll.User;
import com.example.w3.web.utils.Util;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/ChaServlet")
public class ChaServlet extends HttpServlet {
    private final JdbcTemplate jt = new JdbcTemplate(Util.getDs());
    String sql = "select * from user";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = jt.query(sql, new BeanPropertyRowMapper<>(User.class));
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        for (User em : users) {
            writer.write(em.getPassword());
            writer.write(em.getUsername());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
