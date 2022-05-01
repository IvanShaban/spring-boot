package com.example.servingwebcontent.service;

import com.example.servingwebcontent.exception.DeviceNotFoundException;
import com.example.servingwebcontent.service.dto.DeviceCreateDto;
import com.example.servingwebcontent.service.dto.DeviceDto;
import com.example.servingwebcontent.repository.DeviceRepository;
import com.example.servingwebcontent.repository.entity.Device;
import com.example.servingwebcontent.service.mapper.DeviceMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class DeviceService {
    private final DeviceRepository deviceRepository;

    public void create(DeviceCreateDto deviceCreateDto) {
        deviceRepository.save(DeviceMapper.INSTANCE.deviceCreateDtoToDevice(deviceCreateDto));
    }

    public List<DeviceDto> getAll() {
        return StreamSupport.stream(deviceRepository.findAll().spliterator(), false)
                .map(DeviceMapper.INSTANCE::deviceToDeviceDto)
                .collect(Collectors.toList());
    }

    public DeviceDto getById(Long id) {
        Optional<Device> device = deviceRepository.findById(id);
        String exceptionMessage = StringUtils.join("Device with id ", id, " not found");
        return DeviceMapper.INSTANCE.deviceToDeviceDto(device.orElseThrow(() -> new DeviceNotFoundException(exceptionMessage)));
    }

    public void update(DeviceDto deviceDto) {
        deviceRepository.save(DeviceMapper.INSTANCE.deviceDtoToDevice(deviceDto));
    }

    public void delete(Long id) {
        deviceRepository.deleteById(id);
    }
}
