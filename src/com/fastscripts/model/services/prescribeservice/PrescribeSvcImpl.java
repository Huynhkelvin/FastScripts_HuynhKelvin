package com.fastscripts.model.services.prescribeservice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

import com.fastscripts.model.domain.Patient;
import com.fastscripts.model.domain.Prescription;
import com.fastscripts.model.services.exceptions.PrescribeException;

public class PrescribeSvcImpl implements IPrescribeSvc {

	/**
	 * Store the prescription into the system, returns true if correctly stored.
	 * 
	 * @param Prescription
	 *            contains prescription information.
	 * 
	 */
	public boolean storePrescribe(Patient patientPrescription) throws PrescribeException {

		ObjectOutputStream output = null;
		ObjectInputStream input = null;
		boolean hasStored = false;
		try {
			output = new ObjectOutputStream(new FileOutputStream("Prescription.txt"));
			Hashtable<Integer, Patient> prescriptionHashtableTest = new Hashtable<Integer, Patient>();

			prescriptionHashtableTest.put(1, patientPrescription);

			output.writeObject(prescriptionHashtableTest);
			output.close();

			input = new ObjectInputStream(new FileInputStream("Prescription.txt"));
			@SuppressWarnings("unchecked")
			Hashtable<Integer, Patient> prescriptionHashtable = (Hashtable<Integer, Patient>) input.readObject();
			int sizeOfHash = prescriptionHashtable.size();
			input.close();

			prescriptionHashtable.put(sizeOfHash + 1, patientPrescription);

			output = new ObjectOutputStream(new FileOutputStream("Prescription.txt"));
			output.writeObject(prescriptionHashtable);
			output.close();

			input = new ObjectInputStream(new FileInputStream("Prescription.txt"));
			@SuppressWarnings("unchecked")
			Hashtable<Integer, Patient> prescriptionCheck = (Hashtable<Integer, Patient>) input.readObject();
			Patient patientPrescriptionTest = (Patient) prescriptionCheck.get(sizeOfHash + 1);

			if (patientPrescription != null) {
				if (patientPrescription.equals(patientPrescriptionTest))
					hasStored = true;
				else
					hasStored = false;
			} else {
				throw new PrescribeException("Null Prescription passed to PrescribeSvc::prescription");
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("File 'Patient Prescription.txt' is not found");
			throw new PrescribeException("File 'Patient Prescription.txt' is not found", fnfe);
		} catch (IOException ioe) {
			System.out.println("IOException while accessing 'Patient Prescription.txt'");
			throw new PrescribeException("IOException while accessing 'Patient Prescription.txt'", ioe);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("ClassNotFoundException while reading file 'Patient Prescription.txt'");
			throw new PrescribeException("ClassNotFoundException while reading file 'Patient Prescription.txt'", cnfe);
		} finally {
			if (patientPrescription != null) {
				try {
					input.close();
					output.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return hasStored;
	}

	/**
	 * @param Patient
	 *            contains patient information to be compared to text file
	 * @return Prescription returns patient prescription
	 */
	public Prescription getPrescribe(Patient patient) throws PrescribeException {

		ObjectInputStream input = null;
		boolean hasPrescription = false;
		try {
			input = new ObjectInputStream(new FileInputStream("Prescription.txt"));
			@SuppressWarnings("unchecked")
			Hashtable<Integer, Patient> patientInfo = (Hashtable<Integer, Patient>) input.readObject();
			hasPrescription = patientInfo.contains(patient);
		} catch (FileNotFoundException fnfe) {
			System.out.println("File 'Patient Prescription.txt' is not found");
			throw new PrescribeException("File 'Patient Prescription.txt' is not found", fnfe);
		} catch (IOException ioe) {
			System.out.println("IOException while accessing 'Patient Prescription.txt'");
			throw new PrescribeException("IOException while accessing 'Patient Prescription.txt'", ioe);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("ClassNotFoundException while reading file 'Patient Prescription.txt'");
			throw new PrescribeException("ClassNotFoundException while reading file 'Patient Prescription.txt'", cnfe);
		} finally {
			if (patient.getPrescription() != null) {
				try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if (hasPrescription) {
			return patient.getPrescription();
		} else {
			return null;
		}
	}

}
