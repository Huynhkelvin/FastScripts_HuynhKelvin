package com.fastscripts.model.services.patientservice;
import com.fastscripts.model.domain.Patient;
import com.fastscripts.model.services.IService;
import com.fastscripts.model.services.exceptions.PatientException;

public interface IPatientSvc extends IService{

	public final String NAME = "IPatientSvc";
	
	/**
	 * 
	 * @param patient contains patient information
	 * @return verify if patient is in system
	 * @throws PatientException if file is not found or, patient is null, or an error is encountered while accessing file
	 */
	public boolean verifyPatient(Patient patient) throws PatientException;
	/**
	 * 
	 * @param patient contains patient information
	 * @return return patient information that match
	 * @throws PatientException if file is not found or, patient is null, or an error is encountered while accessing file
	 */
	public Patient getPatient(Patient patient) throws PatientException;

}
