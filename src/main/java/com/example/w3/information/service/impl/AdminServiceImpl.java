package com.example.w3.information.service.impl;

import com.example.w3.information.dao.AdminDao;
import com.example.w3.information.dao.impl.AdminDaoImpl;
import com.example.w3.information.service.AdminService;
import com.example.w3.web.bll.User;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public User login(User user) {
        return adminDao.selectAdmin(user.getUsername(), user.getPassword());
    }
}
