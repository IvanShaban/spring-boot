package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.dao.UserDAO;
import com.example.servingwebcontent.models.Device;
import com.example.servingwebcontent.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserDAO userDAO;

    @Autowired
    public UsersController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping
    public String goToUsersPage(Model model) {
        model.addAttribute("users", userDAO.findAll());
        return "users/start";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDAO.findById(id));
        return "users/personal";
    }

    @GetMapping("/new")
    public String goToCreateUserPage(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/new";
        }
        userDAO.create(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userDAO.findById(id));
        return "users/edit";
    }

    @PostMapping("/{id}/update")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }
        userDAO.update(id, user);
        return "redirect:/users";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        userDAO.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/find")
    public String goToFindUserPage() {
        return "users/find";
    }

    @GetMapping("/delete")
    public String goToDeleteUserPage() {
        return "users/delete";
    }

}
