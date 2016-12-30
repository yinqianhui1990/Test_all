package com.test.webservice.pojo;

/**
 * Created by ThinkPad on 2016/10/25.
 */
import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {

    private String id;
    private String name;
    private String age;
    private String description;

    public User() {
        super();
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
