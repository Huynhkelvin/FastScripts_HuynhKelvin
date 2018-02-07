package com.fastscripts.model.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fastscripts.model.domain.PersonalData;

public class PersonalDataTest {

	/**
	 * Test with valid personal data
	 */
	@Test
	public void testValidate() {
		System.out.println("starting testValidate()");
		PersonalData personalData = new PersonalData("Kelvin", "Huynh", "4081234567", "Kelvin_Huynh@email.com");
		assertTrue ("address validates", personalData.validatePersonalData());
	       System.out.println("testValidate PASSED");
	}
	
	/**
	 * Test if two personal data are equal
	 */
	@Test
	public void testEqualsPersonalData() {
		System.out.println("starting testEqualsPersonalData()");
		PersonalData personalData1 = new PersonalData("Kelvin", "Huynh", "4081234567", "Kelvin_Huynh@email.com");
		PersonalData personalData2 = new PersonalData("Kelvin", "Huynh", "4081234567", "Kelvin_Huynh@email.com");
		assertTrue ("personalData1 equals personalData2", personalData1.equals(personalData2));
	       System.out.println("testEqualsPersonalData PASSED");		
	}
	
	/**
	 * Test if two personal data are not equal
	 */
	@Test
	public void testNotEqualsPersonalData() {
		System.out.println("starting testNotEqualsPersonalData()");
		PersonalData personalData1 = new PersonalData("Kelvin", "Huynh", "4081234567", "Kelvin_Huynh@email.com");
		PersonalData personalData2 = new PersonalData("Kevin", "Huynh", "4081234567", "Kelvin_Huynh@email.com");
		assertFalse ("personalData1 NOT equals personalData2", personalData1.equals(personalData2));
	       System.out.println("testNotEqualsPersonalData PASSED");		
	}
}
