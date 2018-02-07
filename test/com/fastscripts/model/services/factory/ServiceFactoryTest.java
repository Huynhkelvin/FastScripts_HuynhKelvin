package com.fastscripts.model.services.factory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import com.fastscripts.model.services.factory.ServiceFactory;

import com.fastscripts.model.services.prescribeservice.PrescribeSvcImpl;
import com.fastscripts.model.services.prescribeservice.IPrescribeSvc;
import com.fastscripts.model.services.inventoryservice.InventorySvcImpl;
import com.fastscripts.model.services.manager.PropertyManager;
import com.fastscripts.model.services.inventoryservice.IInventorySvc;
import com.fastscripts.model.services.patientservice.PatientSvcImpl;
import com.fastscripts.model.services.patientservice.IPatientSvc;
import com.fastscripts.model.business.exception.ServiceLoadException;


public class ServiceFactoryTest{

	private ServiceFactory serviceFactory;

	@Before
	public void setUp() throws Exception {
		String propertyFileLocation = System.getProperty("prop_location");
		PropertyManager.loadProperties(propertyFileLocation);

		serviceFactory = ServiceFactory.getInstance();
	}
	
	/**
	 *  Test to see if the return of patientSvc and the instance of PatientSvcImpl
	 */
	@Test
	public void testGetPatient() {
		IPatientSvc patientSvc;
		try {
			patientSvc = (IPatientSvc)serviceFactory.getService(IPatientSvc.NAME);
	  	    assertTrue(patientSvc instanceof PatientSvcImpl);
	        System.out.println("testGetPatient PASSED");	  	    
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//fail("ServiceLoadException");
		}
  	}
	
	/**
	 *  Test to see if the return of prescribeSvc and the instance of IPrescribeSvc
	 */
	@Test
	public void testGetPrescribe() {
		IPrescribeSvc prescribeSvc;
		try {
			prescribeSvc = (IPrescribeSvc)serviceFactory.getService(IPrescribeSvc.NAME);
	  	    assertTrue(prescribeSvc instanceof PrescribeSvcImpl);
	        System.out.println("testGetPrescribe PASSED");	  	    
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//fail("ServiceLoadException");
		}
  	}
	
	/**
	 *  Test to see if the return of inventorySvc and the instance of IInventorySvc
	 */
	@Test
	public void testGetInventory() {
		IInventorySvc inventorySvc;
		try {
			inventorySvc = (IInventorySvc)serviceFactory.getService(IInventorySvc.NAME);
	  	    assertTrue(inventorySvc instanceof InventorySvcImpl);
	        System.out.println("testGetInventory PASSED");	  	    
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//fail("ServiceLoadException");
		}	
  	}	
}
