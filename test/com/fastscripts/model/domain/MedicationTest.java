package com.fastscripts.model.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fastscripts.model.domain.Medication;

public class MedicationTest {

	/**
	 * Test with valid medication
	 */
	@Test
	public void testValidate() {
		System.out.println("starting testValidate()");
		Medication medication = new Medication ("Pfizer", "Pill", "09/21/2018", 32, "Antibiotics");
		assertTrue ("medication validates", medication.validateMedication());
	       System.out.println("testValidate PASSED");
	}
	
	/**
	 * Test if two medication are equal
	 */
	@Test
	public void testEqualsMedication() {
		System.out.println("starting testEqualsMedication()");
		Medication medication1 = new Medication ("Pfizer", "Pill", "09/21/2018", 32, "Antibiotics");
		Medication medication2 = new Medication ("Pfizer", "Pill", "09/21/2018", 32, "Antibiotics");
		assertTrue ("medication1 equals medication2", medication1.equals(medication2));
	       System.out.println("testEqualsMedication PASSED");		
	}
	
	/**
	 * Test if two medication are not equal
	 */	
	@Test
	public void testNotEqualsMedication() {
		System.out.println("starting testNotEqualsMedication()");
		Medication medication1 = new Medication ("Pfizer", "Pill", "09/21/2018", 32, "Antibiotics");
		Medication medication2 = new Medication ("Pharma Medica", "Pill", "09/21/2018", 32, "Antibiotics");
		assertFalse ("medication1 NOT equals medication2", medication1.equals(medication2));
	       System.out.println("testNotEqualsMedication PASSED");		
	}
}
