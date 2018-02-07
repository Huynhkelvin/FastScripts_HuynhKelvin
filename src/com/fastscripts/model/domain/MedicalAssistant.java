package com.fastscripts.model.domain;

import java.io.Serializable;

public class MedicalAssistant implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Holds Medical Assistant Personal Information */
	private PersonalData medicalAssistant;
	
	/** Holds Doctor information */
	private Doctor doctor;
	
	/** Holds Medical Assistant's User ID */
	private String userID;
	
	/** Holds Medical Assistant's Password */
	private String password;
	
	
	/**
	 * Default Constructor
	 */
	public MedicalAssistant() {
		super();
	}

	/**
	 * 
	 * @param medicalAssistant
	 * @param doctor
	 * @param userID
	 * @param password
	 */
	public MedicalAssistant(PersonalData medicalAssistant, Doctor doctor, String userID, String password) {
		super();
		this.medicalAssistant = medicalAssistant;
		this.doctor = doctor;
		this.userID = userID;
		this.password = password;
	}
	
	/**
	 * 
	 * @param userID
	 * @param password
	 */
	public MedicalAssistant(String userID, String password) {
		super();
		this.userID = userID;
		this.password = password;
	}

	/**
	 * 
	 * @return The medical assistant
	 */
	public PersonalData getMedicalAssistant() {
		return medicalAssistant;
	}

	/**
	 * 
	 * @param medicalAssistant The medical assistant is used to set
	 */
	public void setMedicalAssistant(PersonalData medicalAssistant) {
		this.medicalAssistant = medicalAssistant;
	}

	/**
	 * 
	 * @return the doctor
	 */
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 * 
	 * @param doctor The doctor is used to set
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/**
	 * 
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * 
	 * @param userID The userID is used to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password The password is used to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 *Validates if each class variable is valid
	 * @return true or false
	 */
	public boolean validateMedicalAssistant()
    {	
    	if (userID            == null) return false;
    	if (password          == null) return false;
    	 
    	
        return true;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		result = prime * result + ((medicalAssistant == null) ? 0 : medicalAssistant.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
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
		MedicalAssistant other = (MedicalAssistant) obj;
		if (doctor == null) {
			if (other.doctor != null)
				return false;
		} else if (!doctor.equals(other.doctor))
			return false;
		if (medicalAssistant == null) {
			if (other.medicalAssistant != null)
				return false;
		} else if (!medicalAssistant.equals(other.medicalAssistant))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MedicalAssistant [medicalAssistant=" + medicalAssistant + ", doctor=" + doctor + ", userID=" + userID
				+ ", password=" + password + "]";
	}
	
	
}
