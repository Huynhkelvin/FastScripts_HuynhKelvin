package com.fastscripts.model.business.manager;

import com.fastscripts.model.business.exception.ServiceLoadException;
import com.fastscripts.model.domain.Patient;
import com.fastscripts.model.services.exceptions.PatientException;
import com.fastscripts.model.services.factory.ServiceFactory;
import com.fastscripts.model.services.patientservice.IPatientSvc;

public class PatientManager extends ManagerSupertype {

	private static PatientManager _instance;

	/**
	 * Private constructor so it can not be called outside, and a default is not
	 * made
	 */
	private PatientManager() {
	}

	/**
	 * Confirms that only one instance of PatientManager is created
	 * 
	 * @return PatientManager instance
	 */
	public static synchronized PatientManager getInstance() {
		if (_instance == null) {
			_instance = new PatientManager();
		}
		return _instance;
	}

	/**
	 * @param serviceName
	 *            Holds the service name (string) so that it can be called
	 * 
	 * @param patient
	 *            Holds patient information to be processed in the services
	 * 
	 * @return action Returns true if action is completed correctly
	 */
	@Override
	public boolean performAction(String serviceName, Patient patient) {
		boolean action = false;
		Patient patientInfo = null;
		if (serviceName.equals("VerifyPatient")) {
			action = verifyPatient(IPatientSvc.NAME, patient);
		} else if (serviceName.equals("GetPatient")) {
			patientInfo = getPatient(IPatientSvc.NAME, patient);
			if (patientInfo != null) {
				action = true;
			}
		}
		return action;
	}

	/**
	 * @param serviceName
	 *            Holds the service name (string) so that it can be called
	 * 
	 * @param patient
	 *            Holds patient information to be processed in the services
	 * 
	 * @return patientInfo Returns Patient data if action is completed correctly
	 */
	@Override
	public Patient performActions(String serviceName, Patient patient) {
		Patient patientInfo = null;
		if (serviceName.equals("GetPatient")) {
			patientInfo = getPatient(IPatientSvc.NAME, patient);
		}
		return patientInfo;
	}

	/**
	 * 
	 * @param serviceName
	 *            Holds the service name (string) so that it can be called
	 * @param patient
	 *            Holds patient information to be processed in the services
	 * @return verify Returns true if patient is in the system
	 */
	public boolean verifyPatient(String serviceName, Patient patient) {
		ServiceFactory factory = ServiceFactory.getInstance();
		IPatientSvc iPatientSvc;
		boolean verify = false;
		try {
			iPatientSvc = (IPatientSvc) factory.getService(serviceName);
			verify = iPatientSvc.verifyPatient(patient);
		} catch (ServiceLoadException e1) {
			System.out.println("PrescribeMedicationManager::getPrescribe failed ServiceLoadException");
			return verify;
		} catch (PatientException e) {
			System.out.println("PrescribeMedicationManager::getPrescribe failed PrescribeException");
			return verify;
		}
		return verify;
	}

	/**
	 * 
	 * @param serviceName
	 *            Holds the service name (string) so that it can be called
	 * @param patient
	 *            Holds patient information to be processed in the services
	 * @return patientInfo Returns Patient data if patient is in the system.
	 */
	public Patient getPatient(String serviceName, Patient patient) {
		ServiceFactory factory = ServiceFactory.getInstance();
		IPatientSvc iPatientSvc;
		Patient patientInfo = null;
		try {
			iPatientSvc = (IPatientSvc) factory.getService(serviceName);
			patientInfo = iPatientSvc.getPatient(patient);
		} catch (ServiceLoadException e1) {
			System.out.println("PrescribeMedicationManager::getPrescribe failed ServiceLoadException");
		} catch (PatientException e) {
			System.out.println("PrescribeMedicationManager::getPrescribe failed PrescribeException");
		}
		return patientInfo;
	}

}
