package com.ifba.middleware.factory;

import com.ifba.middleware.devices.Device;
import com.ifba.middleware.devices.Fan;
import com.ifba.middleware.devices.Light;
import com.ifba.middleware.devices.Sensor;

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