package com.fastscripts.model.services.patientservice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Hashtable;

import com.fastscripts.model.domain.Patient;
import com.fastscripts.model.services.exceptions.PatientException;

public class PatientSvcImpl implements IPatientSvc {

	/**
	 * Verify if patient is in the system, returns true if patient is in the system.
	 * 
	 * @param Patient
	 *            contains Patient information
	 * 
	 */
	public boolean verifyPatient(Patient patient) throws PatientException {
		ObjectInputStream input = null;

		boolean varified = false;
		try {
			input = new ObjectInputStream(new FileInputStream("PatientList.txt"));

			@SuppressWarnings("unchecked")
			Hashtable<Integer, Patient> patientCheck = (Hashtable<Integer, Patient>) input.readObject();
			ArrayList<Patient> list2 = new ArrayList<Patient>(patientCheck.values());
			varified = list2.get(0).getDateOfBirth().equals(patient.getDateOfBirth());

		} catch (FileNotFoundException fnfe) {
			System.out.println("File 'Patient List.txt' is not found");
			throw new PatientException("File 'PatientList.txt' is not found", fnfe);
		} catch (IOException ioe) {
			System.out.println("IOException while accessing 'PatientList.txt'");
			throw new PatientException("IOException while accessing 'PatientList.txt'", ioe);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("ClassNotFoundException while reading file 'PatientList.txt'");
			throw new PatientException("ClassNotFoundException while reading file 'Patient List.txt'", cnfe);
		} finally {
			if (patient != null) {
				try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return varified;
	}

	/**
	 * Retrieve the patient from the system, returns patient.
	 * 
	 * @param Patient
	 *            contains patient information.
	 * 
	 */
	public Patient getPatient(Patient patient) throws PatientException {
		ObjectInputStream input = null;
		Patient patient1 = null;
		boolean varified = false;
		try {
			input = new ObjectInputStream(new FileInputStream("PatientList.txt"));
			@SuppressWarnings("unchecked")
			Hashtable<Integer, Patient> patientCheck = (Hashtable<Integer, Patient>) input.readObject();
			ArrayList<Patient> list2 = new ArrayList<Patient>(patientCheck.values());
			varified = list2.get(0).getDateOfBirth().equals(patient.getDateOfBirth());
			if (varified) {
				patient1 = patientCheck.get(1);
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("File 'Patient List.txt' is not found");
			throw new PatientException("File 'Patient List.txt' is not found", fnfe);
		} catch (IOException ioe) {
			System.out.println("IOException while accessing 'PatientList.txt'");
			throw new PatientException("IOException while accessing 'PatientList.txt'", ioe);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("ClassNotFoundException while reading file 'Patient List.txt'");
			throw new PatientException("ClassNotFoundException while reading file 'PatientList.txt'", cnfe);
		} finally {
			if (patient != null) {
				try {
					input.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if (varified) {
			return patient1;
		} else {
			return null;
		}
	}

}
