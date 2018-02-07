package com.fastscripts.model.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fastscripts.model.domain.Patient;

public class PatientTest {

	/**
	 * Test with valid patient
	 */
	@Test
	public void testValidate() {
		System.out.println("starting testValidate()");
		Patient patient = new Patient ("08/21/2015", "Blue Cross","CA123E");
		assertTrue ("patient validates", patient.validatePatient());
	       System.out.println("testValidate PASSED");
	}
	
	/**
	 * Test if two patient are equal
	 */
	@Test
	public void testEqualsPatient() {
		System.out.println("starting testEqualsPatient()");
		Patient patient1 = new Patient ("08/21/2015", "Blue Cross","CA123E");
		Patient patient2 = new Patient ("08/21/2015", "Blue Cross","CA123E");
		assertTrue ("address1 equals patient2", patient1.equals(patient2));
	       System.out.println("testEqualsPatient PASSED");		
	}
	
	/**
	 * Test if two patient are not equal
	 */
	@Test
	public void testNotEqualsPatient() {
		System.out.println("starting testNotEqualsPatient()");
		Patient patient1 = new Patient ("08/21/2015", "Blue Cross","CA123E");
		Patient patient2 = new Patient ("08/20/2015", "Blue Cross","CA123E");
		assertFalse ("patient1 NOT equals patient2", patient1.equals(patient2));
	       System.out.println("testNotEqualsPatient PASSED");		
	}
}
