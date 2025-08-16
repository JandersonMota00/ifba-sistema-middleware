package com.ifba.middleware.device;

import java.util.UUID;

public class Light implements Device {

    private final String deviceId;
    private final String deviceName;
    private String state;

    public Light(String deviceId, String deviceName, String state) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.state = state;
    }

    @Override
    public String getDeviceId() {
        return deviceId;
    }

    @Override
    public String getDeviceName() {
        return deviceName;
    }

    @Override
    public Object getState() {
        return state;
    }

    @Override
    public void turnOn() {
        this.state = "on";
        System.out.println("Luz '" + this.deviceName + "' foi ligada.");
    }

    @Override
    public void turnOff() {
        this.state = "off";
        System.out.println("Luz '" + this.deviceName + "' foi desligada.");
    }
    
    @Override
    public String toString() {
        return "Light(ID: " + deviceId + ", Nome: " + deviceName + ", Estado: " + state + ")";
    }
}