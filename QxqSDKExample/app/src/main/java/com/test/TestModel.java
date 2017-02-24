package com.test;

/**
 * Created by Administrator on 2017/2/16.
 */
public class TestModel {

    private String name;
    private String email;

    public TestModel() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TestModel(String name, String email) {

        this.name = name;
        this.email = email;
    }
}
