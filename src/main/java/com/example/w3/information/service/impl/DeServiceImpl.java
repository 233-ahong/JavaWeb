package com.example.w3.information.service.impl;

import com.example.w3.information.dao.DeDao;
import com.example.w3.information.dao.impl.DeDaoImpl;
import com.example.w3.information.department.Department;
import com.example.w3.information.department.PageBean;
import com.example.w3.information.service.DeService;

import java.util.List;
import java.util.Map;

public class DeServiceImpl implements DeService {
    private DeDao dao = new DeDaoImpl();

    @Override
    public List<Department> selectAll() {
        return dao.selectAll();
    }

    @Override
    public void addDe(Department department) {
        dao.addDe(department);
    }

    @Override
    public Department findDe(String id) {
        return dao.findDe(id);
    }

    @Override
    public void upData(Department department) {
        dao.upData(department);
    }

    @Override
    public void delDeList(String[] dids) {
        if (dids != null && dids.length > 0) {
            for (String id : dids) {
                dao.delete(id);
            }
        }
    }

    @Override
    public PageBean<Department> findDeByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage <= 0) {
            currentPage = 1;
        }
        PageBean<Department> pb = new PageBean<>();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        int start = (currentPage - 1) * rows;
        List<Department> list = dao.findByPage(start, rows, condition);
        pb.setList(list);
        int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }
}
