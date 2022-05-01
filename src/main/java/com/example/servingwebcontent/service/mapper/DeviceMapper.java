package com.example.servingwebcontent.service.mapper;

import com.example.servingwebcontent.repository.entity.Device;
import com.example.servingwebcontent.service.dto.DeviceCreateDto;
import com.example.servingwebcontent.service.dto.DeviceDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeviceMapper {
    DeviceMapper INSTANCE = Mappers.getMapper(DeviceMapper.class);

    Device deviceCreateDtoToDevice(DeviceCreateDto deviceCreateDto);
    Device deviceDtoToDevice(DeviceDto deviceDto);
    DeviceDto deviceToDeviceDto(Device device);
}
