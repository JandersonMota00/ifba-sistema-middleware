package com.ifba.middleware.factory;

import java.util.Deque;

public interface DeviceFactory {
    Deque createDevice(String deviceType, String deviceName, Object initialState);
}