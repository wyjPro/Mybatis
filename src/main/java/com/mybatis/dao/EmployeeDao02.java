package com.mybatis.dao;

import com.mybatis.bean.EmployeeMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmployeeDao02 {
    //查询所有
    @Select("select * from employee")
    List<EmployeeMapper> getAll();

    //查询单一
    @Select("select * from employee where id = #{id}")
    EmployeeMapper selectone(String id);
}
