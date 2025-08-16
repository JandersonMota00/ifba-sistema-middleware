package com.ifba.middleware.observer;

import java.time.LocalDateTime;
import com.ifba.middleware.observer.EventListener;
import com.ifba.middleware.observer.Event;

public class DeviceEventListener implements EventListener {
    
    @Override
    public void onEvent(Event event) {
        System.out.println(LocalDateTime.now() + " EventHandler recebeu o evento: " + event.getEventType() + " com payload: " + event.getPayload());
    }
}