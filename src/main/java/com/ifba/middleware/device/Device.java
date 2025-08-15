package com.ifba.middleware.device;

public interface Device {
    String getDeviceId();
    String getDeviceName();
    Object getState();
    void turnOn();
    void turnOff();
    String toString();
}