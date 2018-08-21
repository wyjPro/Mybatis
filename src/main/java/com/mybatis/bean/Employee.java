package com.mybatis.bean;

public class Employee {
    private String e_id;
    private String e_name;
    private char e_gender;
    private String e_address;

    private Department depart;

    public Department getDepart() {
        return depart;
    }

    public void setDepart(Department depart) {
        this.depart = depart;
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

    public char getE_gender() {
        return e_gender;
    }

    public void setE_gender(char e_gender) {
        this.e_gender = e_gender;
    }

    public String getE_address() {
        return e_address;
    }

    public void setE_address(String e_address) {
        this.e_address = e_address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "e_id='" + e_id + '\'' +
                ", e_name='" + e_name + '\'' +
                ", e_gender=" + e_gender +
                ", e_address='" + e_address + '\'' +
                ", depart=" + depart +
                '}';
    }
}
