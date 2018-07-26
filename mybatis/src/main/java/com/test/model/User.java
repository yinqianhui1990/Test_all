package com.test.model;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/7/25.
 */
public class User {
    private int id;
    private String name;
    private String password;
    private int age;
    private String sex;

    public User() {
    }

    public User(int id, String name, String password, int age, String sex) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
