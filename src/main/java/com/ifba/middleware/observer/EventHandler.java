package com.ifba.middleware.observer;

import java.time.LocalDateTime;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import com.ifba.middleware.observer.DeviceEvent;

@Component
public class EventHandler implements ApplicationListener<DeviceEvent> {

    @Override
    public void onApplicationEvent(DeviceEvent event) {
        System.out.println(LocalDateTime.now() + " EventHandler recebeu o evento: " + event.getEventType() + " com payload: " + event.getPayload());
    }
}