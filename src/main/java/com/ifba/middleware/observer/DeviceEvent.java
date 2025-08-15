package com.ifba.middleware.observer;

import java.util.Map;

public class DeviceEvent extends java.util.EventObject {
    private final String eventType;
    private final Map<String, Object> payload;

    public DeviceEvent(Object source, String eventType, Map<String, Object> payload) {
        super(source);
        this.eventType = eventType;
        this.payload = payload;
    }

    public String getEventType() { return eventType; }
    public Map<String, Object> getPayload() { return payload; }
}