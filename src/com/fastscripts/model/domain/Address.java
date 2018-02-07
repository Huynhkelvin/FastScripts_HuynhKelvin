package com.fastscripts.model.domain;

import java.io.Serializable;

public class Address implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/** Holds street address */
	private String address;
	
	/** Holds City */
	private String city;
	
	/** Holds the state */
	private String state;
	
	/** Holds the country */
	private String country;
	
	/** Holds the ZIP code */
	private String zip;
	
	/**
	 * Default Constructor
	 */
	public Address() {
		super();
	}

	/**
	 * 
	 * @param address 
	 * @param city
	 * @param state
	 * @param country
	 * @param zip
	 */
	public Address(String address, String city, String state, String country, String zip) {
		super();
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}

	/** 
	 * @return The street address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * 
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 
	 * @return the ZIP code
	 */
	public String getZip() {
		return zip;
	}
	
	/**
	 * 
	 * @param address The address is used to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 
	 * @param city The city is used to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 
	 * @param state The state is used to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 
	 * @param country The country is used to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 
	 * @param zip The zip is used to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 *Validates if each class variable is valid
	 * @return true or false
	 */
	public boolean validateAddress()
	    {		
	    	if (address    == null) return false;
	    	if (city       == null) return false;
	    	if (state      == null) return false;
	    	if (country    == null) return false;
	    	if (zip        == null) return false;
	    	
	        return true;
	    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
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
		Address other = (Address) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [address=" + address + ", city=" + city + ", state=" + state + ", country=" + country + ", zip="
				+ zip + "]";
	} 
}
