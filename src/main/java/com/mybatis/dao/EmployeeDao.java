package com.mybatis.dao;

import com.mybatis.bean.Employee;
import com.mybatis.bean.EmployeeMapper;

import java.util.List;

public interface EmployeeDao {

    //查询所有
    List<Employee> getAll();
    List<Employee> getAll2();

    List<Employee> getAll3();

    //查询单一,使用分步查询和延迟加载
    Employee selone(String id);

    /**
     * 通过部门id查询Employee
     * @param id 部门id
     */
    public List<Employee> getEmpByDeptId(Integer id);
}
