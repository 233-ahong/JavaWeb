package com.example.w3.information.dao.impl;

import com.example.w3.information.dao.IDeDao;
import com.example.w3.information.department.Department;
import com.example.w3.information.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

public class IDeDaoImpl implements IDeDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    private String sql;

    public List<Department> selectAll() {
        sql = "select * from department";
        List<Department> query = template.query(sql, new BeanPropertyRowMapper<Department>(Department.class));
        return query;
    }

    @Override
    public void addDe(Department department) {
        sql = "insert into department values(?,?,?,?)";
        template.update(sql, UUID.randomUUID().toString(), department.getName(), department.getPnumber(),
                department.getDmanager());
    }

    @Override
    public Department findDe(String id) {
        sql = "select * from department where id=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Department>(Department.class), id);
    }

    @Override
    public void upData(Department department) {
        sql = "update department set name=?,Pnumber=?,Dmanager=? where id=?";
        template.update(sql, department.getName(), department.getPnumber(), department.getDmanager(), department.getId());
    }

    @Override
    public void delete(String id) {
        sql = "delete from department where id=?";
        template.update(sql, id);
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        sql = "select count(*) from department where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            String value = condition.get(key)[0];
            if (value != null && !"".equals(value)) {
                sb.append("and ").append(key).append(" like ? ");
                params.add("%" + value + "%");
            }
        }
        return template.queryForObject(sb.toString(), Integer.class, params.toArray());
    }

    @Override
    public List<Department> findByPage(int start, int rows, Map<String, String[]> condition) {
        sql = "select * from department where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            String value = condition.get(key)[0];
            if (value != null && !"".equals(value)) {
                sb.append("and ").append(key).append(" like ? ");
                params.add("%" + value + "%");
            }

        }
        sb.append(" limit ?,? ");
        params.add(start);
        params.add(rows);
        return template.query(sb.toString(), new BeanPropertyRowMapper<Department>(Department.class), params.toArray());
    }
}
