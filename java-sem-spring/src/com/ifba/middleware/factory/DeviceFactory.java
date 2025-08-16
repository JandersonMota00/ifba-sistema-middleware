package com.ifba.middleware.factory;

import com.ifba.middleware.devices.Device;

public interface DeviceFactory {

    Device createDevice(String deviceType, String deviceName, Object initialState);

}
