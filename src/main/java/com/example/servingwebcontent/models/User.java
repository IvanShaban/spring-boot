package com.example.servingwebcontent.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {
    @Min(value = 0, message = "Id shouldn't be less than 0")
    private int id;

    @NotEmpty(message = "Name shouldn't be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30")
    private String name;

    private Sex sex;

    @NotEmpty(message = "Email shouldn't be empty")
    @Email(message = "Enter valid email")
    private String email;

    public User() {
    }

    public User(int id, String name, Sex sex, String email) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.email = email;
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name + " (id = " + id + ")";
    }
}
