package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.service.DeviceService;
import com.example.servingwebcontent.service.dto.DeviceCreateDto;
import com.example.servingwebcontent.service.dto.DeviceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/devices")
@RequiredArgsConstructor
public class DeviceController {
    private final DeviceService deviceService;

    @PostMapping
    public void create(@RequestBody @Valid DeviceCreateDto deviceCreateDto) {
        deviceService.create(deviceCreateDto);
    }

    @GetMapping
    public List<DeviceDto> getAllDevices() {
        return deviceService.getAll();
    }

    @GetMapping("/{id}")
    public DeviceDto getById(@PathVariable("id") Long id) {
        return deviceService.getById(id);
    }

    @PutMapping
    public void update(@RequestBody @Valid DeviceDto deviceDto) {
        deviceService.update(deviceDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        deviceService.delete(id);
    }
}
