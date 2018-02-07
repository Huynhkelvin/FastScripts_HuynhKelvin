package com.fastscripts.model.domain;

import java.io.Serializable;

public class Medication implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Manufacture of the drug */
	private String manufacture;

	/** Drug form pill/syrup/ect */
	private String form;

	/** Drug expiration date */
	private String expiration;

	/** Amount of drugs in mG or mL */
	private int amount;

	/** Type of medicine */
	private String medicineType;

	/** Cost of medication */
	private double cost;

	public Medication() {
		super();
	}

	/**
	 * 
	 * @param manufacture
	 * @param form
	 * @param expiration
	 * @param amount
	 * @param medicineType
	 * @param cost
	 */
	public Medication(String manufacture, String form, String expiration, int amount, String medicineType,
			double cost) {
		super();
		this.manufacture = manufacture;
		this.form = form;
		this.expiration = expiration;
		this.amount = amount;
		this.medicineType = medicineType;
		this.cost = cost;
	}

	public Medication(String manufacture, String form, String expiration, int amount, String medicineType) {
		super();
		this.manufacture = manufacture;
		this.form = form;
		this.expiration = expiration;
		this.amount = amount;
		this.medicineType = medicineType;
	}

	public Medication(String medicineType, String form) {
		this.medicineType = medicineType;
		this.form = form;
	}

	/**
	 * 
	 * @return the manufacture
	 */
	public String getManufacture() {
		return manufacture;
	}

	/**
	 * 
	 * @param manufacture
	 *            The manufacture is used to set
	 */
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	/**
	 * 
	 * @return the drug form
	 */
	public String getForm() {
		return form;
	}

	/**
	 * 
	 * @param form
	 *            The drug form is used to set
	 */
	public void setForm(String form) {
		this.form = form;
	}

	/**
	 * 
	 * @return the expiration
	 */
	public String getExpiration() {
		return expiration;
	}

	/**
	 * 
	 * @param expiration
	 *            The expiration date is used to set
	 */
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	/**
	 * 
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * 
	 * @param amount
	 *            The amount is used to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * 
	 * @return the medicine type
	 */
	public String getMedicineType() {
		return medicineType;
	}

	/**
	 * 
	 * @param medicineType
	 *            the medicine type is used to set
	 */
	public void setMedicineType(String medicineType) {
		this.medicineType = medicineType;
	}

	/**
	 * Validates if each class variable is valid
	 * 
	 * @return true or false
	 */
	public boolean validateMedication() {
		if (manufacture == null)
			return false;
		if (form == null)
			return false;
		if (expiration == null)
			return false;
		if (amount == 0)
			return false;
		if (medicineType == null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((expiration == null) ? 0 : expiration.hashCode());
		result = prime * result + ((form == null) ? 0 : form.hashCode());
		result = prime * result + ((manufacture == null) ? 0 : manufacture.hashCode());
		result = prime * result + ((medicineType == null) ? 0 : medicineType.hashCode());
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
		Medication other = (Medication) obj;
		if (amount != other.amount)
			return false;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (expiration == null) {
			if (other.expiration != null)
				return false;
		} else if (!expiration.equals(other.expiration))
			return false;
		if (form == null) {
			if (other.form != null)
				return false;
		} else if (!form.equals(other.form))
			return false;
		if (manufacture == null) {
			if (other.manufacture != null)
				return false;
		} else if (!manufacture.equals(other.manufacture))
			return false;
		if (medicineType == null) {
			if (other.medicineType != null)
				return false;
		} else if (!medicineType.equals(other.medicineType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Medication [manufacture=" + manufacture + ", form=" + form + ", expiration=" + expiration + ", amount="
				+ amount + ", medicineType=" + medicineType + "]";
	}

}
