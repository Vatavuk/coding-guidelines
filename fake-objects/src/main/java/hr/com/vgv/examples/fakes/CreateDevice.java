package hr.com.vgv.examples.fakes;

public class CreateDevice
{
    private final Devices devices;

    private final DeviceValidation validation;

    private final Alarms alarms;

    public CreateDevice(Devices devices, DeviceValidation validation, Alarms alarms)
    {
        this.devices = devices;
        this.validation = validation;
        this.alarms = alarms;
    }

    void exec(DeviceInput input)
    {
        validation.validate(input);
        if (devices.exists(input.id)) {
            throw new IllegalStateException("device already exists");
        }
        try
        {
            devices.create(input);
        }
        catch (Exception exp)
        {
            alarms.raiseAlarm(exp.getMessage());
            throw exp;
        }
    }
}
