package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.service.UserService;
import com.example.servingwebcontent.service.dto.UserCreateDto;
import com.example.servingwebcontent.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final UserService userService;

    @PostMapping
    public void create(@RequestBody @Valid UserCreateDto userCreateDto) {
        userService.create(userCreateDto);
    }

    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @PutMapping
    public void update(@RequestBody @Valid UserDto userDto) {
        userService.update(userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }
}
