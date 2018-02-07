package com.fastscripts.view.storeprescriptionjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.fastscripts.model.business.manager.PrescribeMedicationManager;
import com.fastscripts.model.domain.Patient;
import com.fastscripts.view.paymentjframe.PaymentJFrame;
import com.fastscripts.view.utilities.MessageDialog;
import com.fastscripts.view.utilities.Utils;

public class StorePrescriptionJFrameController implements ActionListener {

	private StorePrescriptionJFrame storescriptJFrame;
	static Patient patientInfo;

	/** Creates instance of StprePrescriptionJFrameController */
	public StorePrescriptionJFrameController() {
	}

	/**
	 * Constructor
	 * 
	 * @param storescriptJFrame
	 */
	public StorePrescriptionJFrameController(StorePrescriptionJFrame storescriptJFrame) {
		this.storescriptJFrame = storescriptJFrame;

		storescriptJFrame.getStorePrescriptionButton().addActionListener(this);
		storescriptJFrame.getCancelButton().addActionListener(this);
		storescriptJFrame.getOrderPrescriptionButton().addActionListener(this);

		Utils.centerWindow(storescriptJFrame);
		storescriptJFrame.setVisible(true);
	}

	/**
	 * Action events listening
	 */
	public void actionPerformed(ActionEvent event) {
		System.out.println("Inside StorePrescriptionJFrameController::actionPerformed");
		if (event.getSource().equals(storescriptJFrame.getStorePrescriptionButton()))
			storePrescription_actionPreformed(event);
		else if (event.getSource().equals(storescriptJFrame.getCancelButton()))
			cancel_actionPreformed(event);
		else if (event.getSource().equals(storescriptJFrame.getOrderPrescriptionButton()))
			order_actionPreformed(event);
	}

	/**
	 * Action Performed for Cancel Button
	 * 
	 * @param event
	 *            ActionEvent
	 */
	private void cancel_actionPreformed(ActionEvent event) {
		storescriptJFrame.setVisible(false);
		storescriptJFrame.dispose();
	}

	/**
	 * Action Performed for Store Prescription Button
	 * 
	 * @param event
	 */
	private void storePrescription_actionPreformed(ActionEvent event) {
		Patient patient = storescriptJFrame.getStorePrescriptionData(patientInfo);
		PrescribeMedicationManager prescribeMedicationManager = PrescribeMedicationManager.getInstance();

		if (prescribeMedicationManager != null) {
			boolean action = prescribeMedicationManager.performAction("LogPrescription", patient);
			if (action) {
				MessageDialog dialog = new MessageDialog("Prescription has been logged", "It was successful");
				Utils.centerWindow(dialog);
				dialog.setModal(true);
				dialog.setVisible(true);

			} else {
				MessageDialog dialog = new MessageDialog("Prescription has not been logged",
						"Failed - There was an issue");
				Utils.centerWindow(dialog);
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		} else {
			MessageDialog dialog = new MessageDialog("System Error", "Prescription was not stored");
			Utils.centerWindow(dialog);
			dialog.setModal(true);
			dialog.setVisible(true);
		}
	}

	private void order_actionPreformed(ActionEvent event) {
		Patient patient = storescriptJFrame.getStorePrescriptionData(patientInfo);
		@SuppressWarnings("unused")
		PaymentJFrame paymentJFrame = new PaymentJFrame(patient);

	}

}
