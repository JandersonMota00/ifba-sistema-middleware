package com.ifba.middleware.command;

import com.ifba.middleware.device.Device;

public class LightOnCommand implements Command {

    private final Device light;

    public LightOnCommand(Device light) {
        this.light = light;
    }

    @Override
    public String execute() {
        light.turnOn();
        return "Luz '" + light.getDeviceName() + "' ligada.";
    }
}