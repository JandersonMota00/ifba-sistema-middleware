public interface DeviceFactory {

    Device createDevice(String deviceType, String deviceName, Object initialState);

}
