package hr.com.vgv.examples.fakes;

public interface DeviceValidation
{
    void validate(DeviceInput input);

    class Fake implements DeviceValidation {

        private boolean isTriggered;

        @Override
        public void validate(DeviceInput input)
        {
            isTriggered = true;
        }

        public boolean isTriggered() {
            return true;
        }
    }
}
