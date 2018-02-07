package com.fastscripts.model.business.manager;

import org.junit.Before;
import org.junit.Test;

import com.fastscripts.model.domain.Medication;
import com.fastscripts.model.domain.Patient;
import com.fastscripts.model.domain.PersonalData;
import com.fastscripts.model.domain.Prescription;
import com.fastscripts.model.services.prescribeservice.IPrescribeSvc;

import junit.framework.TestCase;

public class PrescribeMedicationManagerTest extends TestCase {

	private PrescribeMedicationManager prescribeMedicationManager;
	private Prescription prescription;
	private Medication medicineInfo;
	private PersonalData personalData;
	private Patient patient;

	@Before
	public void setUp() throws Exception {
		super.setUp();

		prescribeMedicationManager = PrescribeMedicationManager.getInstance();

		medicineInfo = new Medication("Pfizer", "Pill", "09/21/2018", 32, "Antibiotics");
		personalData = new PersonalData("Loki", "Huynh", "4086777474", "Loki@gmail.com");
		prescription = new Prescription(medicineInfo, 54, 100, 3, "With a meal");
		patient = new Patient(personalData, "08/21/2015", "Blue Cross", "CA123E", prescription);
	}

	/**
	 * Test performAction method for LogPrescription
	 */
	@Test
	public final void testPerformActionOnLogPrescription() {
		System.out.println("starting testPerformActionOnLogPrescription()");
		boolean action = prescribeMedicationManager.performAction("LogPrescription", patient);
		assertTrue(action);
		System.out.println("testPerformActionOnLogPrescription PASSED");
	}

	/**
	 * Test performAction method for GetPrescription
	 */
	@Test
	public final void testPerformActionOnGetPrescription() {
		System.out.println("starting testPerformActionOnGetPrescription()");
		boolean action = prescribeMedicationManager.performAction("GetPrescription", patient);
		assertTrue(action);
		System.out.println("testPerformActionOnLogPrescription PASSED");
	}

	/**
	 * Test method for filling perscription
	 */
	@Test
	public final void testFillPrescribe() {
		System.out.println("starting testFillPrescribe()");
		boolean action = prescribeMedicationManager.fillPrescribe(IPrescribeSvc.NAME, patient);
		assertTrue(action);
		System.out.println("testFillPrescribe PASSED");
	}

	/**
	 * Test method for getting prescription
	 */
	public final void testGetPrescribe() {
		System.out.println("starting testGetPrescribe()");
		boolean action = prescribeMedicationManager.performAction("GetPrescription", patient);
		assertTrue(action);
		System.out.println("testGetPrescribe PASSED");
	}

}
