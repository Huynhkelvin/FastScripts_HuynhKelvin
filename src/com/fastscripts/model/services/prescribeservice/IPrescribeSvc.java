package com.fastscripts.model.services.prescribeservice;
import com.fastscripts.model.domain.Patient;
import com.fastscripts.model.domain.Prescription;
import com.fastscripts.model.services.IService;
import com.fastscripts.model.services.exceptions.PrescribeException;

public interface IPrescribeSvc extends IService{
	
	public final String NAME = "IPrescribeSvc";
	
	/**
	 * 
	 * @param patientPrescription contains patient's prescription to be stored
	 * @return boolean returns true if stored correctly
	 * @throws PrescribeException if file is not found or, patient is null, or an error is encountered while accessing file 
	 */
	public boolean storePrescribe(Patient patientPrescription) throws PrescribeException;
	/**
	 * 
	 * @param patient contains patient information
	 * @return Prescription that is assigned to the patient
	 * @throws PrescribeException if file is not found or, patient is null, or an error is encountered while accessing file
	 */
	public Prescription getPrescribe(Patient patient) throws PrescribeException;

}
