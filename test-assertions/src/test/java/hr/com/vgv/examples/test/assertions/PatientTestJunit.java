package hr.com.vgv.examples.test.assertions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PatientTestJunit
{
    @Test
    public void retrievesPatient()
    {
        Patient patient = new Patients().get("patientId");
        assertEquals(patient.getId(), "patientId");
        assertEquals(patient.getName(), "testName");
        assertEquals(patient.getNurse(), "testNurse");
        assertTrue(patient.isActive());
    }
}
