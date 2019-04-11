package model.entity;

import model.entity.enums.Role;


public class Account {
    private int id;
    private Role role;
    private String firstNameUk;
    private String surNameUk;
    private String firstNameUa;
    private String surNameUa;
    private String email;
    private String password;
    private String phone;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getNameUk() {
        return firstNameUk;
    }

    public void setNameUk(String firstNameUk) {
        this.firstNameUk = firstNameUk;
    }

    public String getSurnameUk() {
        return surNameUk;
    }

    public void setSurnameUk(String surNameUk) {
        this.surNameUk = surNameUk;
    }

    public String getNameUa() {
        return firstNameUa;
    }

    public void setNameUa(String firstNameUa) {
        this.firstNameUa = firstNameUa;
    }

    public String getSurnameUa() {
        return surNameUa;
    }

    public void setSurnameUa(String surNameUa) {
        this.surNameUa = surNameUa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
