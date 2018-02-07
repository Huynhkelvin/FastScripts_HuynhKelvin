package com.fastscripts.model.services.prescribeservice;

import com.fastscripts.model.services.exceptions.PrescribeException;
import com.fastscripts.model.services.factory.ServiceFactory;
import com.fastscripts.model.services.manager.PropertyManager;
import com.fastscripts.model.business.exception.ServiceLoadException;
import com.fastscripts.model.domain.Prescription;
import com.fastscripts.model.domain.Medication;
import com.fastscripts.model.domain.Patient;
import com.fastscripts.model.domain.PersonalData;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class PrescribeSvcImplTest extends TestCase{

	private ServiceFactory serviceFactory;
	private Prescription prescription1;
	private Patient patient1;
	private PersonalData loki;
	private Medication medicineInfo;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		
		String propertyFileLocation = System.getProperty("prop_location");
		PropertyManager.loadProperties(propertyFileLocation);

		serviceFactory = ServiceFactory.getInstance();
		
		medicineInfo = new Medication("Pfizer", "Pill", "09/21/2018", 32, "Antibiotics");
		loki = new PersonalData("Loki", "Huynh", "4086777474", "Loki@gmail.com");
		prescription1 = new Prescription (medicineInfo, 54, 100, 3, "With a meal");
		patient1 = new Patient(loki, "08/21/2015", "Blue Cross","CA123E", prescription1);

	}

	@Test
	public void testStorePrescribe() {
		IPrescribeSvc prescribeSvc;
		System.out.println("starting testStorePrescribe()");
		try{
			prescribeSvc = (IPrescribeSvc) serviceFactory.getService(IPrescribeSvc.NAME);
			assertTrue(prescribeSvc.storePrescribe(patient1));
			System.out.println("testGetInventory PASSED");
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PrescribeException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("PrescribeException");
		}
	}

	@Test
	public void testGetPrescribe() {
		IPrescribeSvc prescribeSvc;
		System.out.println("starting testGetPrescribe()");
		try{
			prescribeSvc = (IPrescribeSvc) serviceFactory.getService(IPrescribeSvc.NAME);
			prescribeSvc.storePrescribe(patient1);
			assertTrue(prescription1.equals(prescribeSvc.getPrescribe(patient1)));
			System.out.println("testGetInventory PASSED");
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PrescribeException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("PrescribeException");
		}
	}
}
