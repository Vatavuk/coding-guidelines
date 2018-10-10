package hr.com.vgv.examples.business_logic;

public interface PayloadAdapter
{
    Iterable<Payload> convert(String message);
}
