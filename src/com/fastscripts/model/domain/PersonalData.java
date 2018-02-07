package com.fastscripts.model.domain;

import java.io.Serializable;

public class PersonalData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Person's First Name */
	private String firstName;

	/** Person's Last Name */
	private String lastName;

	/** Holds Address */
	private Address address;

	/** Holds Phone Number */
	private String phoneNum;

	/** Holds email */
	private String email;

	/**
	 * Default Constructor
	 */
	public PersonalData() {
		super();
	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param phoneNum
	 * @param email
	 */

	public PersonalData(String firstName, String lastName, Address address, String phoneNum, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNum = phoneNum;
		this.email = email;
	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public PersonalData(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param phoneNum
	 * @param email
	 */
	public PersonalData(String firstName, String lastName, String phoneNum, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.email = email;
	}

	/**
	 * 
	 * @return The first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @param firstName
	 *            The firstName is used to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * @return The last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 * @return The address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * 
	 * @param address
	 *            The address is used to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * 
	 * @return The phone number
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * 
	 * @param phoneNum
	 *            The phone number is used to set
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/**
	 * 
	 * @return The Email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 *            The email is used to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Validates if each class variable is valid
	 * 
	 * @return true or false
	 */
	public boolean validatePersonalData() {
		if (firstName == null)
			return false;
		if (lastName == null)
			return false;
		if (phoneNum == null)
			return false;
		if (email == null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phoneNum == null) ? 0 : phoneNum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonalData other = (PersonalData) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneNum == null) {
			if (other.phoneNum != null)
				return false;
		} else if (!phoneNum.equals(other.phoneNum))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PersonalData [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", phoneNum=" + phoneNum + ", email=" + email + "]";
	}

}
