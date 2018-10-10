package hr.com.vgv.examples.business_logic;

import java.util.Iterator;
import java.util.function.Supplier;

public class PayloadsOf implements Payloads
{
    private final Supplier<Payloads> origin;

    public PayloadsOf(String message, PayloadAdapter adapter)
    {
        this.origin = () -> adapter.convert(message);
    }

    @Override
    public Iterator<Payload> iterator()
    {
        return this.origin.get().iterator();
    }
}
