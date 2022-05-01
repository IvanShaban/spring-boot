package com.example.servingwebcontent.service.mapper;

import com.example.servingwebcontent.repository.entity.User;
import com.example.servingwebcontent.service.dto.UserCreateDto;
import com.example.servingwebcontent.service.dto.UserDto;

public class UserMapper {
    public static User toUser(UserCreateDto userCreateDto) {
        return User.builder()
                .name(userCreateDto.getName())
                .sex(userCreateDto.getSex())
                .email(userCreateDto.getEmail())
                .build();
    }

    public static User toUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .sex(userDto.getSex())
                .email(userDto.getEmail())
                .build();
    }

    public static UserDto toUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .sex(user.getSex())
                .email(user.getEmail())
                .build();
    }
}
