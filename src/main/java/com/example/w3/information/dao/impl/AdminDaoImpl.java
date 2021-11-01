package com.example.w3.information.dao.impl;

import com.example.w3.information.dao.IAdminDao;
import com.example.w3.information.utils.JDBCUtils;
import com.example.w3.web.bll.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AdminDaoImpl implements IAdminDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    private String sql;

    @Override
    public User selectAdmin(String username, String password) {
        try {
            sql = "select * from user where username=? and password=?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
