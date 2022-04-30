package com.example.servingwebcontent.service.dto;

import com.example.servingwebcontent.repository.entity.Type;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Value
public class DeviceCreateDto {
    @NotBlank
    String name;
    @NotNull
    Type type;
    Integer ownerId;
}