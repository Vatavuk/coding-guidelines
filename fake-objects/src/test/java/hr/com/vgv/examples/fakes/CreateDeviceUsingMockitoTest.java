package hr.com.vgv.examples.fakes;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class CreateDeviceUsingMockitoTest
{
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    Devices devices;
    Alarms alarms;
    DeviceValidation validation;

    @Before
    public void setup()
    {
        devices = mock(Devices.class);
        alarms = mock(Alarms.class);
        validation = mock(DeviceValidation.class);
    }

    @Test
    public void createsDevice()
    {
        DeviceInput input = new DeviceInput("testId", "testName");
        when(devices.exists("testId")).thenReturn(false);
        ArgumentCaptor<DeviceInput> inputCaptor = ArgumentCaptor.forClass(DeviceInput.class);

        new CreateDevice(
            devices, validation, alarms
        ).exec(input);

        verify(validation).validate(input);
        verifyNoMoreInteractions(validation);
        verify(devices).create(inputCaptor.capture());
        verifyNoMoreInteractions(alarms);

        Assert.assertThat(
            inputCaptor.getValue().name, new IsEqual<>("testName")
        );
    }

    @Test
    public void failsWhenCreatingSameDeviceTwice() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage("device already exists");

        when(devices.exists("testDeviceId")).thenReturn(true);

        new CreateDevice(
            devices, validation, alarms
        ).exec(new DeviceInput("testDeviceId", "testDeviceName"));
    }
}
