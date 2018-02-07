package com.fastscripts.model.services.inventoryservice;

import com.fastscripts.model.services.exceptions.InventoryException;
import com.fastscripts.model.services.factory.ServiceFactory;
import com.fastscripts.model.services.manager.PropertyManager;
import com.fastscripts.model.domain.Inventory;
import com.fastscripts.model.domain.Medication;
import com.fastscripts.model.business.exception.ServiceLoadException;
import junit.framework.TestCase;


import org.junit.Before;
import org.junit.Test;

public class InventorySvcImplTest extends TestCase{

	private ServiceFactory serviceFactory;
	private Inventory medication;
	private Inventory medication2;
	private Medication medicine;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		
		String propertyFileLocation = System.getProperty("prop_location");
		PropertyManager.loadProperties(propertyFileLocation);

		serviceFactory = ServiceFactory.getInstance();
		medicine = new Medication ("Pfizer", "Pill", "09/21/2018", 32, "Antibiotics");
		medication = new Inventory (medicine, "San Jose");
		medication2 = new Inventory (medicine, "San Jose");
		medication.setMedication(medicine);
	}

	@Test
	public void testGetInventory(){
		IInventorySvc inventorySvc;
		System.out.println("starting testGetInventory()");
		try{
			inventorySvc = (IInventorySvc) serviceFactory.getService(IInventorySvc.NAME);
			inventorySvc.storeInventory(medication2);
			assertTrue(medication2.equals(inventorySvc.getInventory(medication)));
			System.out.println("testGetInventory PASSED");
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InventoryException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			//fail("InventoryException");
		}
	}
	
	@Test
	public void teststoreInventory() {
		IInventorySvc inventorySvc;
		System.out.println("starting testStoreInventory()");
		try{
			inventorySvc = (IInventorySvc) serviceFactory.getService(IInventorySvc.NAME);
			assertTrue(inventorySvc.storeInventory(medication));
			System.out.println("testGetInventory PASSED");
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InventoryException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			//fail("InventoryException");
		}
	}
}
