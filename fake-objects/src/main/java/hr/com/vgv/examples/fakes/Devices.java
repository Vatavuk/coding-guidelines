package hr.com.vgv.examples.fakes;

import java.util.HashMap;
import java.util.Map;

public interface Devices
{
    void create(DeviceInput device);

    Device get(String deviceId);

    boolean exists(String deviceId);

    class Fake implements Devices {

        private final Map<String, Device> devices = new HashMap<>();

        @Override
        public void create(DeviceInput device)
        {
            this.devices.put(device.id, new Device.Fake(device));
        }

        @Override
        public Device get(String deviceId)
        {
            return devices.get(deviceId);
        }

        @Override
        public boolean exists(String deviceId)
        {
            return devices.containsKey(deviceId);
        }
    }
}
