package hr.com.vgv.examples.test.assertions;

public class Patients
{
    public Patient get(String patientId) {
        return Patient.builder()
            .id(patientId)
            .name("testName")
            .nurse("testNurse")
            .active(true)
            .build();
    }
}
