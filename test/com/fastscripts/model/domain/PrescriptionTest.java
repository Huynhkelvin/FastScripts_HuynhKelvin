package com.fastscripts.model.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fastscripts.model.domain.Prescription;

public class PrescriptionTest {

	/**
	 * Test with valid prescription
	 */
	@Test
	public void testValidate() {
		System.out.println("starting testValidate()");
		Prescription prescription = new Prescription (54, 100, 3, "With a meal");
		assertTrue ("prescription validates", prescription.validatePrescription());
	       System.out.println("testValidate PASSED");
	}
	
	/**
	 * Test if two prescription are equal
	 */
	@Test
	public void testEqualsPrescription() {
		System.out.println("starting testEqualsPrescription()");
		Prescription prescription1 = new Prescription (54, 100, 3, "With a meal");
		Prescription prescription2 = new Prescription (54, 100, 3, "With a meal");
		assertTrue ("prescription1 equals prescription2", prescription1.equals(prescription2));
	       System.out.println("testEqualsPrescription PASSED");		
	}
	
	/**
	 * Test if two prescription are no equal
	 */
	@Test
	public void testNotEqualsPrescription() {
		System.out.println("starting testNotEqualsPrescription()");
		Prescription prescription1 = new Prescription (54, 100, 3, "With a meal");
		Prescription prescription2 = new Prescription (54, 200, 5, "With a meal");
		assertFalse ("prescription1 NOT equals prescription2", prescription1.equals(prescription2));
	       System.out.println("testNotEqualsPrescription PASSED");		
	}
}
