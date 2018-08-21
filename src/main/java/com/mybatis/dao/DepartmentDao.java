package com.mybatis.dao;

import com.mybatis.bean.Department;

public interface DepartmentDao {
    //association
    Department selectone(String id);

    //collection
    Department getDeptWithEmpByStep(String id);
}
