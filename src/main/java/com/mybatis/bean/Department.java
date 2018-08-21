package com.mybatis.bean;

import java.util.Collection;
import java.util.List;

public class Department {
    private String e_id;
    private String e_name;
    private Collection<Employee> emps;

    public Collection<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "e_id='" + e_id + '\'' +
                ", e_name='" + e_name + '\'' +
                '}';
    }
}
