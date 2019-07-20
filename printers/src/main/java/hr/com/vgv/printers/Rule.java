package hr.com.vgv.printers;

public interface Rule
{
    String urn();

    <T> T print(Output<T> out);

    void update(RuleInput input);
}
