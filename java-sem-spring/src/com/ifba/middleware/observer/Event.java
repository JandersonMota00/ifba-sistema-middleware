package com.ifba.middleware.observer;

import java.util.Map;

public interface Event {

    String getEventType();
    Map<String, Object> getPayload();

}
