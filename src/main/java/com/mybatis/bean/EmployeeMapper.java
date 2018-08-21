package com.mybatis.bean;

import java.io.Serializable;

public class EmployeeMapper implements Serializable {
    //对象关系映射，把数据库中的记录映射成java类中的类对象，一条记录对应一个类对象
    //那么这个类就被称为JavaBean或者叫Entity（实体类）
    private String id;
    private String name;
    private char gender;
    private String address;

    public EmployeeMapper(){}
    public EmployeeMapper(String id, String name, char gender, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "EmployeeMapper{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                '}';
    }
}
