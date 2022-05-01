package com.example.servingwebcontent.service;

import com.example.servingwebcontent.exception.UserNotFoundException;
import com.example.servingwebcontent.repository.UserRepository;
import com.example.servingwebcontent.repository.entity.User;
import com.example.servingwebcontent.service.dto.UserCreateDto;
import com.example.servingwebcontent.service.dto.UserDto;
import com.example.servingwebcontent.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void create(UserCreateDto userCreateDto) {
        userRepository.save(UserMapper.INSTANCE.userCreateDtoToUser(userCreateDto));
    }

    public List<UserDto> getAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(UserMapper.INSTANCE::userToUserDto)
                .collect(Collectors.toList());
    }

    public UserDto getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        String exceptionMessage = StringUtils.join("User with id ", id, " not found");
        return UserMapper.INSTANCE.userToUserDto(user.orElseThrow(()-> new UserNotFoundException(exceptionMessage)));
    }

    public void update(UserDto userDto) {
        userRepository.save(UserMapper.INSTANCE.userDtoToUser(userDto));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
