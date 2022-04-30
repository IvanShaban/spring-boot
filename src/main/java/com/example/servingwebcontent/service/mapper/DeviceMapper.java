package com.example.servingwebcontent.service.mapper;

import com.example.servingwebcontent.service.dto.DeviceCreateDto;
import com.example.servingwebcontent.service.dto.DeviceDto;
import com.example.servingwebcontent.repository.entity.Device;

public class DeviceMapper {
    public static Device toDevice(DeviceCreateDto deviceDto) {
        return Device.builder()
                .name(deviceDto.getName())
                .ownerId(deviceDto.getOwnerId())
                .type(deviceDto.getType())
                .build();
    }

    public static Device toDevice(DeviceDto deviceDto) {
        return Device.builder()
                .id(deviceDto.getId())
                .name(deviceDto.getName())
                .ownerId(deviceDto.getOwnerId())
                .type(deviceDto.getType())
                .build();
    }

    public static DeviceDto toDeviceDto(Device device) {
        return DeviceDto.builder()
                .id(device.getId())
                .name(device.getName())
                .ownerId(device.getOwnerId())
                .type(device.getType())
                .build();
    }
}
