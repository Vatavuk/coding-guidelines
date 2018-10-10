package hr.com.vgv.examples.business_logic;

import java.util.Iterator;
import java.util.function.Supplier;

public class UserDevicePayloads implements Payloads
{
    private final Supplier<Payloads> origin;

    public UserDevicePayloads(User user, Payloads payloads)
    {
        this.origin = () -> {
            for (Device device: user.devices()) {
                device.storePayloads(payloads);
            }
            return payloads;
        };
    }

    @Override
    public Iterator<Payload> iterator()
    {
        return this.origin.get().iterator();
    }
}
