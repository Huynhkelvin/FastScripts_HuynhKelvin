package com.fastscripts.model.domain;

import java.io.Serializable;

public class Doctor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Doctor's information (address, phone, ect.. ) */
	private PersonalData doctorInfo;
	
	/** Holds National Provider Identifier */
	private String addressMPI;
	
	/** Holds the DEA number for the Doctor */
	private String numDEA;
	
	/**
	 * Default Constructor
	 */
	public Doctor() {
		super();
	}

	/**
	 * 
	 * @param doctorInfo
	 * @param addressMPI
	 * @param numDEA
	 */
	public Doctor(PersonalData doctorInfo, String addressMPI, String numDEA) {
		super();
		this.doctorInfo = doctorInfo;
		this.addressMPI = addressMPI;
		this.numDEA = numDEA;
	}
	
	/**
	 * 
	 * @param addressMPI
	 * @param numDEA
	 */
	public Doctor(String addressMPI, String numDEA) {
		super();
		this.addressMPI = addressMPI;
		this.numDEA = numDEA;
	}

	/**
	 * 
	 * @return Doctor's Information
	 */
	public PersonalData getDoctorInfo() {
		return doctorInfo;
	}

	/**
	 * 
	 * @param doctorInfo The doctor's info is used to set
	 */
	public void setDoctorInfo(PersonalData doctorInfo) {
		this.doctorInfo = doctorInfo;
	}

	/**
	 * 
	 * @return the MPI address
	 */
	public String getAddressMPI() {
		return addressMPI;
	}

	/**
	 * 
	 * @param addressMPI The MPI address is used to set
	 */
	public void setAddressMPI(String addressMPI) {
		this.addressMPI = addressMPI;
	}

	/**
	 * 
	 * @return the DEA number
	 */
	public String getNumDEA() {
		return numDEA;
	}

	/**
	 * @param numDEA The DEA number is used to set
	 */
	public void setNumDEA(String numDEA) {
		this.numDEA = numDEA;
	}
	
	/**
	 *Validates if each class variable is valid
	 * @return true or false
	 */
	public boolean validateDoctor()
    {		
    	if (addressMPI   == null) return false;
    	if (numDEA       == null) return false;  	 
    	
        return true;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressMPI == null) ? 0 : addressMPI.hashCode());
		result = prime * result + ((doctorInfo == null) ? 0 : doctorInfo.hashCode());
		result = prime * result + ((numDEA == null) ? 0 : numDEA.hashCode());
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
		Doctor other = (Doctor) obj;
		if (addressMPI == null) {
			if (other.addressMPI != null)
				return false;
		} else if (!addressMPI.equals(other.addressMPI))
			return false;
		if (doctorInfo == null) {
			if (other.doctorInfo != null)
				return false;
		} else if (!doctorInfo.equals(other.doctorInfo))
			return false;
		if (numDEA == null) {
			if (other.numDEA != null)
				return false;
		} else if (!numDEA.equals(other.numDEA))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Doctor [doctorInfo=" + doctorInfo + ", addressMPI=" + addressMPI + ", numDEA=" + numDEA + "]";
	}
	
}
