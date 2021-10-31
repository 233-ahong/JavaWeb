package com.example.w3.web.test;

import com.example.w3.web.bll.User;
import com.example.w3.web.utils.Util;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.annotations.Test;

import java.util.List;

public class SqlTest {
    private final JdbcTemplate jt = new JdbcTemplate(Util.getDs());
    String sql = null;

    @Test
    public void testSQL3() {
        sql = "select * from user";
        List<User> emap = jt.query(sql, new BeanPropertyRowMapper<>(User.class));
        for (User em : emap) {
            System.out.println(em);
        }
    }

    @Test
    public void testSQL1() {
        sql = "insert into user value(null,?,?)";
        int count = jt.update(sql, "李四", "1235");
        System.out.println(count);
    }
}
