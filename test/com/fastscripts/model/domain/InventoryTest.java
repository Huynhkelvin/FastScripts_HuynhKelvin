package com.fastscripts.model.domain;


import org.junit.Test;


import junit.framework.TestCase;

public class InventoryTest extends TestCase{
	
	private Medication medication1;
	private Medication medication2;
	public void setUp() throws Exception {
		super.setUp();
				
		medication1 = new Medication ("Pfizer", "Pill", "09/21/2018", 32, "Antibiotics");
		medication2 = new Medication ("Pfizer", "Pill", "09/21/2019", 32, "Antibiotics");
	}

	/**
	 * Test with valid Inventory
	 */
	@Test
	public void testValidate() {
		System.out.println("starting testValidate()");
		Inventory inventory = new Inventory (medication1, "Q1W2E3");
		assertTrue ("Inventory validates", inventory.validateInventory());
	       System.out.println("testValidate PASSED");
	}
	
	/**
	 * Test if two inventories are equal
	 */
	@Test
	public void testEqualsInventory() {
		System.out.println("starting testEqualsInventory()");
		Inventory inventory1 = new Inventory (medication1, "Q1W2E3");
		Inventory inventory2 = new Inventory (medication1, "Q1W2E3");
		assertTrue ("inventory1 equals inventory2", inventory1.equals(inventory2));
	       System.out.println("testEqualsInventory PASSED");		
	}

	/**
	 * Test if two inventories are not equal
	 */
	@Test
	public void testNotEqualsInventory() {
		System.out.println("starting testNotEqualsInventory()");
		Inventory inventory1 = new Inventory (medication1, "Q1W2E3");
		Inventory inventory2 = new Inventory (medication2, "Q1W2E3");
		assertFalse ("inventory1 equals inventory2", inventory1.equals(inventory2));
	       System.out.println("testNotEqualsInventory PASSED");		
	}
}
