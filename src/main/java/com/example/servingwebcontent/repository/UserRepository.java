package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.repository.entity.Sex;
import com.example.servingwebcontent.repository.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private static int COUNT;
    private static List<User> users;

    static {
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
