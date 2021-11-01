package com.example.w3.information.dao;

import com.example.w3.information.department.Department;

import java.util.List;
import java.util.Map;

public interface IDeDao {
    public List<Department> selectAll();

    void addDe(Department department);

    Department findDe(String id);

    void upData(Department department);

    void delete(String id);

    /**
     * 查询总记录数
     *
     * @param condition
     * @return
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询
     *
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<Department> findByPage(int start, int rows, Map<String, String[]> condition);
}
