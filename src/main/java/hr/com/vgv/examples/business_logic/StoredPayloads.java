package hr.com.vgv.examples.business_logic;

import java.util.Iterator;

public class StoredPayloads implements Payloads
{
    private final Payloads payloads;

    public StoredPayloads(UserSource user, Users users, String message, PayloadAdapter adapter)
    {
        this.payloads = new UserDevicePayloads(
            new ProvisionedUser(user, users),
            new PayloadsOf(message, adapter)
        );
    }

    @Override
    public Iterator<Payload> iterator()
    {
        return payloads.iterator();
    }
}
