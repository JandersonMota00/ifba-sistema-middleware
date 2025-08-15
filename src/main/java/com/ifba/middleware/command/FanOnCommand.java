package com.ifba.middleware.command;

import com.ifba.middleware.device.Device;

public class FanOnCommand implements Command {

    private final Device fan;

    public FanOnCommand(Device fan) {
        this.fan = fan;
    }

    @Override
    public String execute() {
        fan.turnOn();
        return "Ventilador '" + fan.getDeviceName() + "' ligado.";
    }
}