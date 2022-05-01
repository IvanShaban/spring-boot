package com.example.servingwebcontent.service.mapper;

import com.example.servingwebcontent.repository.entity.User;
import com.example.servingwebcontent.service.dto.UserCreateDto;
import com.example.servingwebcontent.service.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userCreateDtoToUser(UserCreateDto userCreateDto);
    User userDtoToUser(UserDto userDto);
    UserDto userToUserDto(User user);
}
