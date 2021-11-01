package com.example.w3.information.service.impl;

import com.example.w3.information.dao.IAdminDao;
import com.example.w3.information.dao.impl.AdminDaoImpl;
import com.example.w3.information.service.IAdminService;
import com.example.w3.web.bll.User;

public class AdminServiceImpl implements IAdminService {
    private IAdminDao adminDao = new AdminDaoImpl();

    @Override
    public User login(User user) {
        return adminDao.selectAdmin(user.getUsername(), user.getPassword());
    }
}
