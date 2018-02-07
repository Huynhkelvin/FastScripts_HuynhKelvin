package com.fastscripts.model.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AddressTest.class, DoctorTest.class, MedicalAssistantTest.class, MedicationTest.class,
		PatientTest.class, PersonalDataTest.class, PrescriptionTest.class })
public class AllDomainTests {

}
