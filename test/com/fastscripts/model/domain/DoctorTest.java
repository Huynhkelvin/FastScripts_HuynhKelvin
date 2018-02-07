package com.fastscripts.model.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fastscripts.model.domain.Doctor;

public class DoctorTest {

	/**
	 * Test with a valid doctor
	 */
	@Test
	public void testValidate() {
		System.out.println("starting testValidate()");
		Doctor doctor = new Doctor ("1A2B3C", "Q1W2E3");
		assertTrue ("address validates", doctor.validateDoctor());
	       System.out.println("testValidate PASSED");
	}
	
	/**
	 * Test if two doctor are equal
	 */
	@Test
	public void testEqualsDoctor() {
		System.out.println("starting testEqualsDoctor()");
		Doctor doctor1 = new Doctor ("1A2B3C", "Q1W2E3");
		Doctor doctor2 = new Doctor ("1A2B3C", "Q1W2E3");
		assertTrue ("doctor1 equals doctor2", doctor1.equals(doctor2));
	       System.out.println("testEqualsDoctor PASSED");		
	}
	
	/**
	 * Test if two doctor are not equal
	 */
	@Test
	public void testNotEqualsDoctor() {
		System.out.println("starting testNotEqualsDoctor()");
		Doctor doctor1 = new Doctor ("1A2B3C", "Q1W2E3");
		Doctor doctor2 = new Doctor ("1A2B2C", "Q1W2E3");
		assertFalse ("doctor1 equals doctor2", doctor1.equals(doctor2));
	       System.out.println("testNotEqualsDoctor PASSED");		
	}
}
