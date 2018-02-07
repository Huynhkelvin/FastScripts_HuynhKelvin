package com.fastscripts.model.domain;

import java.io.Serializable;

public class Inventory implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Medication information */
	private Medication medication;
	
	/** Location of medication */
	private String location;
	
	/**
	 * Default constructor
	 */
	public Inventory() {
		super();
	}

	/**
	 * 
	 * @param medication
	 * @param location
	 */
	public Inventory(Medication medication, String location) {
		super();
		this.medication = medication;
		this.location = location;
	}

	/**
	 * 
	 * @return the medication
	 */
	public Medication getMedication() {
		return medication;
	}

	/**
	 * 
	 * @param medication The medication is used to set
	 */
	public void setMedication(Medication medication) {
		this.medication = medication;
	}

	/**
	 * 
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * 
	 * @param location The location is used to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	public boolean validateInventory()
    {		
    	if (location       == null) return false;
    	if (medication     == null) return false;   	
        return true;
    }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((medication == null) ? 0 : medication.hashCode());
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
		Inventory other = (Inventory) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (medication == null) {
			if (other.medication != null)
				return false;
		} else if (!medication.equals(other.medication))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Inventory [medication=" + medication + ", location=" + location + "]";
	}
}
