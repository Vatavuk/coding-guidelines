package hr.com.vgv.examples.business_logic;

import java.util.function.Supplier;

public class ProvisionedUser implements User
{
    private final Supplier<User> user;

    public ProvisionedUser(UserSource source, Users users)
    {
        this.user = () -> {
            String id = source.id();
            User user;
            if (users.exists(id)) {
                user  = users.get(id);
            } else {
                user = users.create(source);
            }
            return user;
        };
    }

    @Override
    public Iterable<Device> devices()
    {
        return this.user.get().devices();
    }
}
