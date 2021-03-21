package com.example.competition.model;

/**
 * @author Chen Anran
 * @date 2021/3/20
 */
public class User {
    private int id;
    private String name;
    private String password;
    private String phone;
    private int status;
    private int gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println(id);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}