package com.example.w3.information.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(value = "/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req= (HttpServletRequest) request;
        String uri = req.getRequestURI();
        if (uri.contains("/index.jsp")||uri.contains("/loginServlet")||uri.contains("/CheckCodeServlet")) {
            chain.doFilter(request, response);
        }else {
            Object user=req.getSession().getAttribute("user");
            if (user!=null){
                chain.doFilter(request, response);
            }else {
                req.setAttribute("login_msg","您尚未登录，请先登录");
                req.getRequestDispatcher("/index.jsp").forward(req,response);
            }
        }
    }
}
