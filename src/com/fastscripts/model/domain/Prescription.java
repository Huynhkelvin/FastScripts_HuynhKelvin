package com.fastscripts.model.domain;

import java.io.Serializable;

public class Prescription implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Holds the prescribed medication */
	private Medication prescribedMedication;

	/** Holds the prescribed dosage */
	private int dose;

	/** Hold the medication count */
	private int count;

	/** Holds the dosing */
	private int dosing;

	/** Holds the medication instruction */
	private String instructions;

	public Prescription() {
		super();
	}

	/**
	 * 
	 * @param dose
	 * @param count
	 * @param dosing
	 * @param instructions
	 */
	public Prescription(int dose, int count, int dosing, String instructions) {
		super();
		this.dose = dose;
		this.count = count;
		this.dosing = dosing;
		this.instructions = instructions;
	}

	/**
	 * 
	 * @param prescribedMedication
	 * @param dose
	 * @param count
	 * @param dosing
	 * @param instructions
	 */
	public Prescription(Medication prescribedMedication, int dose, int count, int dosing, String instructions) {
		super();
		this.prescribedMedication = prescribedMedication;
		this.dose = dose;
		this.count = count;
		this.dosing = dosing;
		this.instructions = instructions;
	}

	/**
	 * 
	 * @param prescribedMedication
	 * @param dose
	 * @param count
	 * @param dosing
	 */
	public Prescription(Medication prescribedMedication, int dose, int count, int dosing) {
		super();
		this.prescribedMedication = prescribedMedication;
		this.dose = dose;
		this.count = count;
		this.dosing = dosing;
	}

	/**
	 * 
	 * @return prescribedMedication
	 */
	public Medication getPrescribedMedication() {
		return prescribedMedication;
	}

	/**
	 * 
	 * @param prescribedMedication
	 *            The prescribedMedication is used to set
	 */
	public void setPrescribedMedication(Medication prescribedMedication) {
		this.prescribedMedication = prescribedMedication;
	}

	/**
	 * 
	 * @return dose
	 */
	public int getDose() {
		return dose;
	}

	/**
	 * 
	 * @param dose
	 *            The dose is used to set
	 */
	public void setDose(int dose) {
		this.dose = dose;
	}

	/**
	 * 
	 * @return count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * 
	 * @param count
	 *            The count is used to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * 
	 * @return dosing
	 */
	public int getDosing() {
		return dosing;
	}

	/**
	 * 
	 * @param dosing
	 *            The dosing is used to set
	 */
	public void setDosing(int dosing) {
		this.dosing = dosing;
	}

	/**
	 * 
	 * @return instructions
	 */
	public String getInstructions() {
		return instructions;
	}

	/**
	 * 
	 * @param instructions
	 *            The instructions is used to set
	 */
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	/**
	 * Validates if each class variable is valid
	 * 
	 * @return true or false
	 */
	public boolean validatePrescription() {
		if (dose == 0)
			return false;
		if (count == 0)
			return false;
		if (dosing == 0)
			return false;
		if (instructions == null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + dose;
		result = prime * result + dosing;
		result = prime * result + ((instructions == null) ? 0 : instructions.hashCode());
		result = prime * result + ((prescribedMedication == null) ? 0 : prescribedMedication.hashCode());
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
		Prescription other = (Prescription) obj;
		if (count != other.count)
			return false;
		if (dose != other.dose)
			return false;
		if (dosing != other.dosing)
			return false;
		if (instructions == null) {
			if (other.instructions != null)
				return false;
		} else if (!instructions.equals(other.instructions))
			return false;
		if (prescribedMedication == null) {
			if (other.prescribedMedication != null)
				return false;
		} else if (!prescribedMedication.equals(other.prescribedMedication))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prescription [prescribedMedication=" + prescribedMedication + ", dose=" + dose + ", count=" + count
				+ ", dosing=" + dosing + ", instructions=" + instructions + "]";
	}

}
