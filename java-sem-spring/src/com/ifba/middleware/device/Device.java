package com.ifba.middleware.device;

import java.util.UUID;

public interface Device {

    String getDeviceId();
    String getDeviceName();
    Object getState();
    void turnOn();
    void turnOff();
    String toString();
    
}
