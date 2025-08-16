public interface Event {

    String getEventType();
    Map<String, Object> getPayload();

}
