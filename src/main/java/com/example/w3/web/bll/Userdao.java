package com.example.w3.web.bll;

import com.example.w3.web.utils.Util;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class Userdao {
    private final JdbcTemplate template = new JdbcTemplate(Util.getDs());
    private String sql;

    public User login(User loginuser) {
        try {
            sql = "select * from user where username= ? and password= ?";
            return template.queryForObject(sql,
                    new BeanPropertyRowMapper<>(User.class),
                    loginuser.getUsername(), loginuser.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User ceshi(User cheshi) {
        User user = null;
        try {
            sql = sql = "select * from user where username=?";
            user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<>(User.class),
                    cheshi.getUsername());
        } catch (DataAccessException e) {
            return null;
        }
        return user;
    }

    public User Zhuce(User zhuce) {
        if (ceshi(zhuce) != null) {
            return null;
        } else {
            String sql1 = "insert into user value(null,?,?)";
            sql = "select * from user where username=? and password=?";
            int count = template.update(sql1, zhuce.getUsername(), zhuce.getPassword());
            if (count > 0) {
                try {
                    return template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),
                            zhuce.getUsername(), zhuce.getPassword());
                } catch (DataAccessException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return null;
        }
    }

}
