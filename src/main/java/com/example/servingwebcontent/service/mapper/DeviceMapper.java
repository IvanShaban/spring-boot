package com.example.servingwebcontent.service.mapper;

import com.example.servingwebcontent.service.dto.DeviceCreateDto;
import com.example.servingwebcontent.service.dto.DeviceDto;
import com.example.servingwebcontent.repository.entity.Device;

public class DeviceMapper {
    public static Device toDevice(DeviceCreateDto deviceCreateDto) {
        return Device.builder()
                .name(deviceCreateDto.getName())
                .type(deviceCreateDto.getType())
                .ownerId(deviceCreateDto.getOwnerId())
                .build();
    }

    public static Device toDevice(DeviceDto deviceDto) {
        return Device.builder()
                .id(deviceDto.getId())
                .name(deviceDto.getName())
                .type(deviceDto.getType())
                .ownerId(deviceDto.getOwnerId())
                .build();
    }

    public static DeviceDto toDeviceDto(Device device) {
        return DeviceDto.builder()
                .id(device.getId())
                .name(device.getName())
                .type(device.getType())
                .ownerId(device.getOwnerId())
                .build();
    }
}
