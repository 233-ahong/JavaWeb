package com.example.w3.information.dao;

import com.example.w3.web.bll.User;

public interface AdminDao {
    public User selectAdmin(String username, String password);
}
