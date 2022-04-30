package com.example.servingwebcontent.dao;

import com.example.servingwebcontent.models.Sex;
import com.example.servingwebcontent.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private static int COUNT;
    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(++COUNT, "Ivan", Sex.MALE, "ivan@mail.com"));
        users.add(new User(++COUNT, "Darya", Sex.FEMALE, "darya@mail.com"));
        users.add(new User(++COUNT, "Yegermeystar", Sex.MALE, "igor@mail.com"));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void create(User user) {
        user.setId(++COUNT);
        users.add(user);
    }

    public void update(int id, User updatedUser) {
        User user = findById(id);
        user.setName(updatedUser.getName());
        user.setSex(updatedUser.getSex());
        user.setEmail(updatedUser.getEmail());
    }

    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
