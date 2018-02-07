package com.fastscripts.model.domain;

import java.io.Serializable;

public class Patient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Holds patient personal data */
	private PersonalData patientInfo;

	/** Holds date of birth */
	private String dateOfBirth;

	/** Holds patient insurance provider */
	private String insuranceProvider;

	/** Holds subscriber ID */
	private String subscriberID;

	/** Holds Prescription */
	private Prescription prescription;

	/**
	 * Default Constructor
	 */
	public Patient() {
		super();
	}

	/**
	 * 
	 * @param dateOfBirth
	 * @param insuranceProvider
	 * @param subscriberID
	 */
	public Patient(String dateOfBirth, String insuranceProvider, String subscriberID) {
		super();
		;
		this.dateOfBirth = dateOfBirth;
		this.insuranceProvider = insuranceProvider;
		this.subscriberID = subscriberID;
	}

	/**
	 * 
	 * @param patientInfo
	 * @param prescription
	 * @param dateOfBirth
	 */
	public Patient(PersonalData patientInfo, Prescription prescription, String dateOfBirth) {
		super();
		;
		this.patientInfo = patientInfo;
		this.prescription = prescription;
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * 
	 * @param patientInfo
	 * @param dateOfBirth
	 * @param insuranceProvider
	 * @param subscriberID
	 * @param prescription
	 */
	public Patient(PersonalData patientInfo, String dateOfBirth, String insuranceProvider, String subscriberID,
			Prescription prescription) {
		super();
		this.patientInfo = patientInfo;
		this.dateOfBirth = dateOfBirth;
		this.insuranceProvider = insuranceProvider;
		this.subscriberID = subscriberID;
		this.prescription = prescription;
	}

	/**
	 * 
	 * @param patientInfo
	 * @param dateOfBirth
	 * @param insuranceProvider
	 * @param subscriberID
	 */
	public Patient(PersonalData patientInfo, String dateOfBirth, String insuranceProvider, String subscriberID) {
		super();
		this.patientInfo = patientInfo;
		this.dateOfBirth = dateOfBirth;
		this.insuranceProvider = insuranceProvider;
		this.subscriberID = subscriberID;
	}

	public Patient(PersonalData patientInfo, String dateOfBirth) {
		super();
		this.patientInfo = patientInfo;
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * 
	 * @return patient info
	 */
	public PersonalData getPatientInfo() {
		return patientInfo;
	}

	/**
	 * 
	 * @param patientInfo
	 *            The patientInfo is used to set
	 */
	public void setPatientInfo(PersonalData patientInfo) {
		this.patientInfo = patientInfo;
	}

	/**
	 * 
	 * @return dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * 
	 * @param dateOfBirth
	 *            The dateOfBirth is used to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * 
	 * @return insuranceProvider;
	 */
	public String getInsuranceProvider() {
		return insuranceProvider;
	}

	/**
	 * 
	 * @param insuranceProvider
	 *            The insuranceProvider is used to set
	 */
	public void setInsuranceProvider(String insuranceProvider) {
		this.insuranceProvider = insuranceProvider;
	}

	/**
	 * 
	 * @return subscriberID
	 */
	public String getSubscriberID() {
		return subscriberID;
	}

	/**
	 * 
	 * @param subscriberID
	 *            The subscriberID is used to set
	 */
	public void setSubscriberID(String subscriberID) {
		this.subscriberID = subscriberID;
	}

	/**
	 * 
	 * @return prescription
	 */
	public Prescription getPrescription() {
		return prescription;
	}

	/**
	 * 
	 * @param prescription
	 *            The prescription is used to set
	 */
	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	/**
	 * Validates if each class variable is valid
	 * 
	 * @return true or false
	 */
	public boolean validatePatient() {
		if (dateOfBirth == null)
			return false;
		if (insuranceProvider == null)
			return false;
		if (subscriberID == null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((insuranceProvider == null) ? 0 : insuranceProvider.hashCode());
		result = prime * result + ((patientInfo == null) ? 0 : patientInfo.hashCode());
		result = prime * result + ((prescription == null) ? 0 : prescription.hashCode());
		result = prime * result + ((subscriberID == null) ? 0 : subscriberID.hashCode());
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
		Patient other = (Patient) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (insuranceProvider == null) {
			if (other.insuranceProvider != null)
				return false;
		} else if (!insuranceProvider.equals(other.insuranceProvider))
			return false;
		if (patientInfo == null) {
			if (other.patientInfo != null)
				return false;
		} else if (!patientInfo.equals(other.patientInfo))
			return false;
		if (prescription == null) {
			if (other.prescription != null)
				return false;
		} else if (!prescription.equals(other.prescription))
			return false;
		if (subscriberID == null) {
			if (other.subscriberID != null)
				return false;
		} else if (!subscriberID.equals(other.subscriberID))
			return false;
		return true;
	}
}
