package com.mybatis.dao;

import com.mybatis.bean.EmployeeMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeDao01 {

    /**
     * 1.单参数的Mybatis不会做特殊处理：#{...}
     * 2.传入对象POJO：#{对象的属性名称}
     * 3.多个参数 Mybatis做特殊处理，会把传入的参数自动封装成Map类型
     *      Map的Key值就是从param1...paramN
     *      map.put("param1",name);
     *      map.put("param2",gender);
     * 4.多个参数,直接传入Map
     */
    //查询所有
    List<EmployeeMapper> getAll();

    //查询单一
    EmployeeMapper selectone(String id);

    //新增
    void insertEmp(EmployeeMapper emp);

    //修改
    void updateEmp(EmployeeMapper emp);

    //删除
    void deleteEmp(String id);

    //多条件查询
    //List<EmployeeMapper> queryList(String name, char gender);
    List<EmployeeMapper> queryList(@Param("name") String name, @Param("gender") char gender);

    //多条件查询Map
    List<EmployeeMapper> queryList2(Map map);

    //动态查询if
    List<EmployeeMapper> qureyByif(EmployeeMapper emp);

    //动态查询choose
    List<EmployeeMapper> qureyBychoose(EmployeeMapper emp);

    //动态查询trim
    List<EmployeeMapper> qureyBytrim(EmployeeMapper emp);

    //动态查询批量操作foreach
    Integer deleteByList(List<EmployeeMapper> list);
    Integer deleteByArray(String[] strs);

    //动态查询set
    Integer updataBySet(EmployeeMapper emp);
}
