package com.ifba.middleware.observer;

import java.util.ArrayList;
import java.util.List;
import com.ifba.middleware.observer.EventListener;
import com.ifba.middleware.observer.Event;

public class EventPublisher {
    
    private final List<EventListener> listeners = new ArrayList<>();

    public void addListener(EventListener listener) {
        listeners.add(listener);
    }
    
    public void publishEvent(Event event) {
        for (EventListener listener : listeners) {
            listener.onEvent(event);
        }
    }

}
