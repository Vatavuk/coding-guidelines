package hr.com.vgv.examples.fakes;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CreateDeviceUsingFakesTest
{
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    Devices devices;
    Alarms.Fake alarms;
    DeviceValidation.Fake validation;

    @Before
    public void setup() {
        devices = new Devices.Fake();
        alarms = new Alarms.Fake();
        validation = new DeviceValidation.Fake();
    }

    @Test
    public void createsDevice()
    {
        new CreateDevice(
            devices, validation, alarms
        ).exec(new DeviceInput("testId", "testName"));

        Assert.assertThat(
            devices.get("testId").name(), new IsEqual<>("testName")
        );
        Assert.assertTrue(validation.isTriggered());
        Assert.assertFalse(alarms.isRaised());
    }

    @Test
    public void failsWhenCreatingSameDeviceTwice() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage("device already exists");

        DeviceInput input = new DeviceInput("firstDeviceId", "firstDevice");
        devices.create(input);

        new CreateDevice(
            devices, validation, alarms
        ).exec(input);
    }
}
