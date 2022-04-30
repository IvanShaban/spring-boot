package com.example.servingwebcontent.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Device {
    @Min(value = 0, message = "Id shouldn't be less than 0")
    private int id;

    @NotEmpty(message = "Name shouldn't empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;

    private Type type;
    private User owner;

    public Device() {
    }

    public Device(int id, String name, Type type, User owner) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.owner = owner;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
