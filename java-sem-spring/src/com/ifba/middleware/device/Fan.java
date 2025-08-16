package com.ifba.middleware.device;

import java.util.UUID;

public class Fan implements Device {

    private final String deviceId;
    private final String deviceName;
    private String state;

    public Fan(String deviceId, String deviceName, String state) {
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
        System.out.println("Ventilador '" + this.deviceName + "' foi ligado.");
    }

    @Override
    public void turnOff() {
        this.state = "off";
        System.out.println("Ventilador '" + this.deviceName + "' foi desligado.");
    }
    
    @Override
    public String toString() {
        return "Fan(ID: " + deviceId + ", Nome: " + deviceName + ", Estado: " + state + ")";
    }
}