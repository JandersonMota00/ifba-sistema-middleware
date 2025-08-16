public class Sensor implements Device {

    private final String deviceId;
    private final String deviceName;
    private Integer value;

    public Sensor(String deviceId, String deviceName, Integer initialValue) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.value = initialValue;
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
        return value;
    }

    public Integer readValue() {
        return value;
    }

    public void updateValue(Integer newValue) {
        this.value = newValue;
    }

    // Sensores não têm estado on/off, portanto, estes métodos não fazem nada.
    @Override
    public void turnOn() {}
    
    @Override
    public void turnOff() {}

    @Override
    public String toString() {
        return "Sensor(ID: " + deviceId + ", Nome: " + deviceName + ", Leitura: " + value + "°C)";
    }
}