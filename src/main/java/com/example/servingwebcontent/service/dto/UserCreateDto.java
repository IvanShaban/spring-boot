package com.example.servingwebcontent.service.dto;

import com.example.servingwebcontent.repository.entity.Sex;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Value
public class UserCreateDto {
    @NotBlank
    String name;
    @NotNull
    Sex sex;
    String email;
}
