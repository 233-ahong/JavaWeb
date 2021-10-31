package com.example.w3.information.service;

import com.example.w3.information.department.Department;
import com.example.w3.information.department.PageBean;

import java.util.List;
import java.util.Map;

public interface DeService {
    /**
     * 查询所有
     *
     * @return
     */
    public List<Department> selectAll();

    /**
     * 添加department
     *
     * @param department
     */
    void addDe(Department department);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Department findDe(String id);

    /**
     * 修改部门信息
     *
     * @param department
     */
    void upData(Department department);

    /**
     * 批量删除
     *
     * @param dids
     */
    void delDeList(String[] dids);

    /**
     * 分页条件查询
     *
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<Department> findDeByPage(String currentPage, String rows, Map<String, String[]> condition);
}
