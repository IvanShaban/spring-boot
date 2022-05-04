package com.example.servingwebcontent.service;

import com.example.servingwebcontent.repository.DeviceRepository;
import com.example.servingwebcontent.repository.entity.Device;
import com.example.servingwebcontent.repository.entity.Type;
import com.example.servingwebcontent.service.dto.DeviceDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeviceServiceTest {
    @InjectMocks
    private DeviceService deviceService;
    @Mock
    private DeviceRepository mockDeviceRepository;

    @AfterEach
    private void checkInteractions() {
        verifyNoMoreInteractions(mockDeviceRepository);
    }

    @Test
    private void shouldSuccessfullyReturnDeviceById() {
        when(mockDeviceRepository.findById(anyLong())).thenReturn(createExpectedDevice());
        DeviceDto device = deviceService.getById(1L);
        assertThat(device.getOwnerId(), isNotNull());
        assertThat(device.getName(), equalTo("Device"));
        verify(mockDeviceRepository.findById(1L));
    }

    private Optional<Device> createExpectedDevice() {
        return Optional.of(Device.builder()
                .name("Device")
                .type(Type.LAPTOP)
                .id(1L)
                .ownerId(1L)
                .build());
    }
}
