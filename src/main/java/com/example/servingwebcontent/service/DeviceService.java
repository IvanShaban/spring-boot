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

    public DeviceDto getById(Long id) {
        Optional<Device> device = deviceRepository.findById(id);
        String exceptionMessage = StringUtils.join("Device with id ", id, " not found");
        return DeviceMapper.toDeviceDto(device.orElseThrow(() -> new DeviceNotFoundException(exceptionMessage)));
    }

    public List<DeviceDto> getAll() {
        return StreamSupport.stream(deviceRepository.findAll().spliterator(), false)
                .map(DeviceMapper::toDeviceDto)
                .collect(Collectors.toList());

    }

    public void create(DeviceCreateDto deviceCreateDto) {
        deviceRepository.save(DeviceMapper.toDevice(deviceCreateDto));
    }

    public void update(DeviceDto deviceDto) {
        deviceRepository.save(DeviceMapper.toDevice(deviceDto));
    }

    public void delete(Long id) {
        deviceRepository.deleteById(id);
    }
}
