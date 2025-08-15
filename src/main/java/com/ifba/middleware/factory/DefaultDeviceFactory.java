package com.ifba.middleware.factory;

import java.util.Deque;

import org.springframework.stereotype.Component;

import com.ifba.middleware.device.Device;
import com.ifba.middleware.device.Fan;
import com.ifba.middleware.device.Light;
import com.ifba.middleware.device.Sensor;

@Component
public class DefaultDeviceFactory implements DeviceFactory {

    @Override
    public Device createDevice(String deviceType, String deviceName, Object initialState) {
        String deviceId = deviceType + "_" + deviceName.replace(" ", "_");
        switch (deviceType.toLowerCase()) {
            case "light":
                return new Light(deviceId, deviceName, (String) initialState);
            case "fan":
                return new Fan(deviceId, deviceName, (String) initialState);
            case "sensor":
                return new Sensor(deviceId, deviceName, (Integer) initialState);
            default:
                throw new IllegalArgumentException("Tipo de dispositivo desconhecido: " + deviceType);
        }
    }
}