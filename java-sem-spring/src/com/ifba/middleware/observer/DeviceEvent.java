package com.ifba.middleware.observer;

import java.util.Map;
import com.ifba.middleware.observer.Event;

public class DeviceEvent implements Event {

    private final String eventType;
    private final Map<String, Object> payload;

    public DeviceEvent(String eventType, Map<String, Object> payload) {
        this.eventType = eventType;
        this.payload = payload;
    }

    public String getEventType() {
        return eventType;
    }

    public Map<String, Object> getPayload() {
        return payload;
    }
}