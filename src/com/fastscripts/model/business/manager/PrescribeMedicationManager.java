package com.fastscripts.model.business.manager;

import com.fastscripts.model.business.exception.ServiceLoadException;
import com.fastscripts.model.domain.Patient;
import com.fastscripts.model.domain.Prescription;
import com.fastscripts.model.services.exceptions.PrescribeException;
import com.fastscripts.model.services.factory.ServiceFactory;
import com.fastscripts.model.services.prescribeservice.IPrescribeSvc;

public class PrescribeMedicationManager extends ManagerSupertype {

	private static PrescribeMedicationManager _instance;

	/**
	 * Private constructor so it can not be called outside, and a default is not
	 * made
	 */
	private PrescribeMedicationManager() {
	}

	/**
	 * Confirms that only one instance of PrescribeMedicationManager is created
	 * 
	 * @return PrescribeMedicationManager instance
	 */
	public static synchronized PrescribeMedicationManager getInstance() {

		if (_instance == null) {
			_instance = new PrescribeMedicationManager();
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
		Prescription prescription = null;

		if (serviceName.equals("LogPrescription")) {
			action = fillPrescribe(IPrescribeSvc.NAME, patient);
		} else if (serviceName.equals("GetPrescription")) {
			prescription = getPrescribe(IPrescribeSvc.NAME, patient);
			if (prescription != null) {
				action = true;
			}
		}
		return action;
	}

	/**
	 * 
	 * @param serviceName
	 *            Holds the service name (string) so that it can be called
	 * @param patient
	 *            Holds patient information to be processed in the services
	 * @return filled Returns true if prescription is correctly stored.
	 */
	public boolean fillPrescribe(String serviceName, Patient patient) {

		boolean filled = false;
		ServiceFactory factory = ServiceFactory.getInstance();
		IPrescribeSvc iPrescribeSvc;
		try {
			iPrescribeSvc = (IPrescribeSvc) factory.getService(serviceName);
			filled = iPrescribeSvc.storePrescribe(patient);
		} catch (ServiceLoadException e1) {
			System.out.println("PrescribeMedicationManager::fillPrescribe failed");
			return filled;
		} catch (PrescribeException e) {
			System.out.println("PrescribeMedicationManager::fillPrescribe failed");
			return filled;
		}

		return filled;
	}

	/**
	 * 
	 * @param serviceName
	 *            Holds the service name (string) so that it can be called
	 * @param patient
	 *            Holds patient information to be processed in the services
	 * @return filled Returns true if prescription is correctly retrieved.
	 */
	public Prescription getPrescribe(String serviceName, Patient patient) {

		ServiceFactory factory = ServiceFactory.getInstance();
		Prescription prescription = null;
		IPrescribeSvc iPrescribeSvc;
		try {
			iPrescribeSvc = (IPrescribeSvc) factory.getService(serviceName);
			prescription = iPrescribeSvc.getPrescribe(patient);
		} catch (ServiceLoadException e1) {
			System.out.println("PrescribeMedicationManager::getPrescribe failed ServiceLoadException");
			return prescription;
		} catch (PrescribeException e) {
			System.out.println("PrescribeMedicationManager::getPrescribe failed PrescribeException");
			return prescription;
		}

		return prescription;
	}

	@Override
	public Patient performActions(String serviceName, Patient patient) {
		return null;
	}
}
