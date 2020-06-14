package hr.com.vgv.examples.fakes;

public interface Device
{
    String id();

    String name();

    class Fake implements Device {

        private final DeviceInput input;

        public Fake(DeviceInput input)
        {
            this.input = input;
        }

        @Override
        public String id()
        {
            return input.id;
        }

        @Override
        public String name()
        {
            return input.name;
        }
    }
}
