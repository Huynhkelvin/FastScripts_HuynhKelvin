package com.fastscripts.model.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fastscripts.model.domain.MedicalAssistant;

public class MedicalAssistantTest {

	/**
	 * Test with a valid Medical Assistant
	 */
	@Test
	public void testValidate() {
		System.out.println("starting testValidate()");
		MedicalAssistant assistant = new MedicalAssistant("Admin", "Password");
		assertTrue ("address validates", assistant.validateMedicalAssistant());
	       System.out.println("testValidate PASSED");
	}
	
	/**
	 * Test if two medical assistant is equal
	 */
	@Test
	public void testEqualsMedicalAssistant() {
		System.out.println("starting testEqualsMedicalAssistant()");
		MedicalAssistant assistant1 = new MedicalAssistant("Admin", "Password");
		MedicalAssistant assistant2 = new MedicalAssistant("Admin", "Password");
		assertTrue ("assistant1 equals assistant2", assistant1.equals(assistant2));
	       System.out.println("testEqualsMedicalAssistant PASSED");		
	}

	/**
	 * Test if two medical assistant is not equal
	 */
	@Test
	public void testNotEqualsMedicalAssistant() {
		System.out.println("starting testNotEqualsMedicalAssistant()");
		MedicalAssistant assistant1 = new MedicalAssistant("Admin", "Password");
		MedicalAssistant assistant2 = new MedicalAssistant("Admin", "abc123");
		assertFalse ("assistant1 NOT equals assistant2", assistant1.equals(assistant2));
	       System.out.println("testNotEqualsMedicalAssistant PASSED");		
	}
}
