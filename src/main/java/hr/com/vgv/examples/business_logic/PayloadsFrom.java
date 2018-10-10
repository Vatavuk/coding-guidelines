package hr.com.vgv.examples.business_logic;

import java.util.Iterator;

public class PayloadsFrom implements Iterable<Payload>
{
    private final String message;

    private final PayloadAdapter adapter;

    public PayloadsFrom(String message, PayloadAdapter adapter)
    {
        this.message = message;
        this.adapter = adapter;
    }

    @Override
    public Iterator<Payload> iterator()
    {
        return this.adapter.convert(this.message).iterator();
    }
}
