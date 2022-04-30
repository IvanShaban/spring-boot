package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.dao.DeviceDAO;
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
@RequestMapping("/devices")
public class DevicesController {
    private final DeviceDAO deviceDAO;
    private final UserDAO userDAO;

    @Autowired
    public DevicesController(DeviceDAO deviceDAO, UserDAO userDAO) {
        this.deviceDAO = deviceDAO;
        this.userDAO = userDAO;
    }

    @GetMapping
    public String goToDevicesPage(Model model) {
        model.addAttribute("devices", deviceDAO.findAll());
        return "devices/start";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        model.addAttribute("device", deviceDAO.findById(id));
        return "devices/personal";
    }

    @GetMapping("/new")
    public String goToCreateDevicePage(@ModelAttribute("device") Device device) {
        return "devices/new";
    }

    @PostMapping
    public String create(@ModelAttribute("device") @Valid Device device, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "devices/new";
        }
        device.setOwner(userDAO.findById(device.getOwner().getId()));
        deviceDAO.create(device);
        return "redirect:/devices";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("device", deviceDAO.findById(id));
        return "devices/edit";
    }

    @PostMapping("/{id}/update")
    public String update(@ModelAttribute("device") @Valid Device device, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "devices/edit";
        }
        device.setOwner(userDAO.findById(device.getOwner().getId()));
        deviceDAO.update(id, device);
        return "redirect:/devices";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        deviceDAO.delete(id);
        return "redirect:/devices";
    }

    @GetMapping("/find")
    public String goToFindDevicePage() {
        return "devices/find";
    }

    @GetMapping("/delete")
    public String goToDeleteUserPage() {
        return "devices/delete";
    }
}
