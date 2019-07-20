package hr.com.vgv.printers;

public interface RuleInput
{
    String urn();

    String name();

    String user();

    <T> T print(Output<T> out);
}