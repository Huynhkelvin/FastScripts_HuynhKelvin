package com.fastscripts.model.services.patientservice;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

import org.junit.Before;
import org.junit.Test;

import com.fastscripts.model.business.exception.ServiceLoadException;
import com.fastscripts.model.domain.Address;
import com.fastscripts.model.domain.Patient;
import com.fastscripts.model.domain.PersonalData;
import com.fastscripts.model.services.exceptions.PatientException;
import com.fastscripts.model.services.factory.ServiceFactory;
import com.fastscripts.model.services.manager.PropertyManager;

import junit.framework.TestCase;

public class PatientSvcImplTest extends TestCase {

	private ServiceFactory serviceFactory;
	private PersonalData nameAndDOB;
	private Address address;
	private Patient patient1;
	private Patient patient2;
	ObjectOutputStream output = null;

	@Before
	public void setUp() throws Exception {
		super.setUp();

		String propertyFileLocation = System.getProperty("prop_location");
		PropertyManager.loadProperties(propertyFileLocation);

		serviceFactory = ServiceFactory.getInstance();
		address = new Address("123 Main Street", "San Jose", "CA", "United States", "95321");
		nameAndDOB = new PersonalData("Kelvin", "Huynh", address, "1234567890", "gmail@gmail");
		patient1 = new Patient(nameAndDOB, "08/21/2015");
		patient2 = new Patient(nameAndDOB, "08/21/2015");

		output = new ObjectOutputStream(new FileOutputStream("PatientList.txt"));
		Hashtable<Integer, Patient> patientHashtable = new Hashtable<Integer, Patient>();
		patientHashtable.put(1, patient1);
		output.writeObject(patientHashtable);
		output.close();

	}

	@Test
	public void testVerifyPatient() {
		IPatientSvc patientSvc;
		System.out.println("starting testVerifyPatient()");
		try {
			patientSvc = (IPatientSvc) serviceFactory.getService(IPatientSvc.NAME);
			assertTrue(patientSvc.verifyPatient(patient1));
			System.out.println("testVerifyPatient PASSED");
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PatientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("PatientException");
		}
	}

	@Test
	public void testGetPatient() {
		IPatientSvc patientSvc;
		System.out.println("starting testGetPatient()");
		try {
			patientSvc = (IPatientSvc) serviceFactory.getService(IPatientSvc.NAME);
			assertTrue(patient2.equals(patientSvc.getPatient(patient1)));
			System.out.println("testGetPatient PASSED");
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PatientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("PatientException");
		}

	}
}
