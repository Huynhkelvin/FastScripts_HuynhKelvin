package com.fastscripts.model.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddressTest {

	/**
	 * Test with a valid address
	 */
	@Test
	public void testValidate() {
		System.out.println("starting testValidate()");
		Address address1 = new Address ("123 Main Street", "San Jose", "CA", "United States", "95321");
		assertTrue ("address validates", address1.validateAddress());
	       System.out.println("testValidate PASSED");
	}
	
	/**
	 * Test if two address are equal
	 */
	@Test
	public void testEqualsAddress() {
		System.out.println("starting testEqualsAddress()");
		Address address1 = new Address ("123 Main Street", "San Jose", "CA", "United States", "95321");
		Address address2 = new Address ("123 Main Street", "San Jose", "CA", "United States", "95321");
		assertTrue ("address1 equals address2", address1.equals(address2));
	       System.out.println("testEqualsAddress PASSED");		
	}
	
	/**
	 * Test if two address are not equal
	 */
	@Test
	public void testNotEqualsAddress() {
		System.out.println("starting testNotEqualsAddress()");
		Address address1 = new Address ("123 Main Street", "San Jose", "CA", "United States", "95321");
		Address address2 = new Address ("321 Main Street", "San Jose", "CA", "United States", "95321");
		assertFalse ("address1 NOT equals address2", address1.equals(address2));
	       System.out.println("testNotEqualsAddress PASSED");		
	}
}
