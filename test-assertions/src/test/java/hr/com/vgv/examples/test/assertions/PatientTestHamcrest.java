package hr.com.vgv.examples.test.assertions;

import org.hamcrest.Description;
import org.junit.Test;
import org.junit.internal.matchers.TypeSafeMatcher;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PatientTestHamcrest
{
    @Test
    public void retrievesPatient()
    {
        assertThat(
            new Patients().get("patientId"),
            new PatientEqualTo(Patient.builder()
                .id("patientId")
                .name("testName")
                .nurse("testNurse")
                .active(true)
                .build()
            )
        );
    }

    private static class PatientEqualTo extends TypeSafeMatcher<Patient>
    {

        private final Patient expected;

        private PatientEqualTo(Patient expected)
        {
            this.expected = expected;
        }

        @Override
        public void describeTo(Description description)
        {
            description.appendText("Patient is not valid");
        }

        @Override
        public boolean matchesSafely(Patient patient)
        {
            assertEquals(patient.getId(), expected.getId());
            assertEquals(patient.getName(), expected.getName());
            assertEquals(patient.getNurse(), expected.getNurse());
            assertEquals(patient.isActive(), expected.isActive());
            return true;
        }
    }
}
