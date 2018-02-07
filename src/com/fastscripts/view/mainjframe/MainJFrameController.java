package com.fastscripts.view.mainjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.fastscripts.model.business.manager.PatientManager;
import com.fastscripts.model.domain.Patient;
import com.fastscripts.model.services.exceptions.PatientException;
import com.fastscripts.view.storeprescriptionjframe.StorePrescriptionJFrame;
import com.fastscripts.view.utilities.MessageDialog;
import com.fastscripts.view.utilities.Utils;

public class MainJFrameController implements ActionListener {

	private MainJFrame patientDataJFrame;

	/**
	 * Creates new instance of patientDataJFrame
	 */
	public MainJFrameController() {
	}

	public MainJFrameController(MainJFrame patientDataJFrame) {
		this.patientDataJFrame = patientDataJFrame;

		patientDataJFrame.getStorePrescriptionButton().addActionListener(this);
		patientDataJFrame.getFileMenuItem().addActionListener(this);
		Utils.centerWindow(patientDataJFrame);
		patientDataJFrame.setVisible(true);
	}

	/**
	 * Action listen for Store Prescription Button
	 */
	public void actionPerformed(ActionEvent event) {

		System.out.println("Inside MainJFrameController::actionPerformed");
		if (event.getSource().equals(patientDataJFrame.getStorePrescriptionButton())) {
			getStorePrescriptionButton_actionPerformed(event);
		} else if (event.getSource().equals(patientDataJFrame.getFileMenuItem())) {
			try {
				menuFileOpen_actionPerformed(event);
			} catch (PatientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * Action Performed for Store Prescription Button
	 * 
	 * @param event
	 *            ActionEvent
	 */
	private void getStorePrescriptionButton_actionPerformed(ActionEvent event) {
		Patient patient = patientDataJFrame.getPatientData();

		PatientManager patientManager = PatientManager.getInstance();

		if (patientManager != null) {
			boolean action = patientManager.performAction("VerifyPatient", patient);
			if (action) {
				patient = patientManager.performActions("GetPatient", patient);
				MessageDialog dialog = new MessageDialog("Patient is in the system", "Patient is verified");
				Utils.centerWindow(dialog);
				dialog.setModal(true);
				dialog.setVisible(true);

				patientDataJFrame.setVisible(false);
				patientDataJFrame.dispose();

				@SuppressWarnings("unused")
				StorePrescriptionJFrame storePrescritionJFrame = new StorePrescriptionJFrame(patient);

			} else {
				MessageDialog dialog = new MessageDialog("Patient is not in the system",
						"Failed - Please register patient");
				Utils.centerWindow(dialog);
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		} else {
			MessageDialog dialog = new MessageDialog("System Error", "Patient was not checked or verified");
			Utils.centerWindow(dialog);
			dialog.setModal(true);
			dialog.setVisible(true);
		}

	}

	void menuFileOpen_actionPerformed(ActionEvent actionEvent) throws PatientException {
		ObjectInputStream input = null;
		ObjectOutputStream output = null;

		try {
			input = new ObjectInputStream(new FileInputStream("PatientList.txt"));
			output = new ObjectOutputStream(new FileOutputStream("PatientListFinal.txt"));
			byte[] buffer = new byte[1024];
			int length;
			while ((length = input.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("File 'Patient List.txt' is not found");
			throw new PatientException("File 'PatientList.txt' is not found", fnfe);
		} catch (IOException ioe) {
			System.out.println("IOException while accessing 'PatientList.txt'");
			throw new PatientException("IOException while accessing 'PatientList.txt'", ioe);
		} finally {
			if (input != null) {
				try {
					input.close();
					output.close();

					MessageDialog dialog = new MessageDialog("Patient File Loading",
							"Patient File has been successfully been loaded");
					Utils.centerWindow(dialog);
					dialog.setModal(true);
					dialog.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
