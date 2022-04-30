package com.example.servingwebcontent.dao;

import com.example.servingwebcontent.models.Device;
import com.example.servingwebcontent.models.Type;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeviceDAO {
    private static int COUNT;
    private List<Device> devices;

    {
        devices = new ArrayList<>();
        devices.add(new Device(++COUNT, "Nokia", Type.PHONE, null));
        devices.add(new Device(++COUNT, "Samsung", Type.PHONE, null));
        devices.add(new Device(++COUNT, "HP", Type.LAPTOP, null));
        devices.add(new Device(++COUNT, "MacBook", Type.LAPTOP, null));
        devices.add(new Device(++COUNT, "LG", Type.MONITOR, null));
        devices.add(new Device(++COUNT, "Samsung", Type.MONITOR, null));
    }

    public List<Device> findAll() {
        return devices;
    }

    public Device findById(int id) {
        return devices.stream().filter(device -> device.getId() == id).findAny().orElse(null);
    }

    public void create(Device device) {
        device.setId(++COUNT);
        devices.add(device);
    }

    public void update(int id, Device updatedDevice) {
        Device device = findById(id);
        device.setName(updatedDevice.getName());
        device.setType(updatedDevice.getType());
        device.setOwner(updatedDevice.getOwner());
    }

    public void delete(int id) {
        devices.removeIf(device -> device.getId() == id);
    }
}
