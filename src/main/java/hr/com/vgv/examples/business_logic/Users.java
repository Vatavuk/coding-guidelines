package hr.com.vgv.examples.business_logic;

public interface Users
{
    User get(String id);

    boolean exists(String id);

    User create(UserSource user);
}
