package com.springTest.bean;

/**
 * Created by ThinkPad on 2016/11/11.
 */
public class Student {
    private String id="123";
    private String name="test";
    private String clazz="c011";

    public Student() {
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

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}
