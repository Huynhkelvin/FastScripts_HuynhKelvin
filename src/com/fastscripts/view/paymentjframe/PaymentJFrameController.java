package com.fastscripts.view.paymentjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.fastscripts.view.utilities.MessageDialog;
import com.fastscripts.view.utilities.Utils;

public class PaymentJFrameController implements ActionListener {

	private PaymentJFrame paymentJFrame;

	/**
	 * Creates new instance of paymentJFrame
	 */
	public PaymentJFrameController() {
	}

	public PaymentJFrameController(PaymentJFrame paymentJFrame) {
		this.paymentJFrame = paymentJFrame;

		paymentJFrame.getOrderInsuranceButton().addActionListener(this);
		paymentJFrame.getOrderPatientButton().addActionListener(this);

		Utils.centerWindow(paymentJFrame);
		paymentJFrame.setVisible(true);
	}

	/**
	 * Action listen for order buttons
	 */
	public void actionPerformed(ActionEvent event) {
		System.out.println("Inside PaymentJFrameController::actionPerformed");
		if (event.getSource().equals(paymentJFrame.getOrderInsuranceButton()))
			orderInsurance_actionPreformed(event);

		else if (event.getSource().equals(paymentJFrame.getOrderPatientButton()))
			orderPatient_actionPreformed(event);
	}

	/**
	 * Action Performed for Order through insurance Prescription Button
	 * 
	 * @param event
	 *            ActionEvent
	 */
	private void orderInsurance_actionPreformed(ActionEvent event) {

		MessageDialog dialog = new MessageDialog("Prescription has been ordered", "Order was successful");
		Utils.centerWindow(dialog);
		dialog.setModal(true);
		dialog.setVisible(true);
	}

	/**
	 * Action Performed for Order through patient Prescription Button
	 * 
	 * @param event
	 *            ActionEvent
	 */
	private void orderPatient_actionPreformed(ActionEvent event) {
		MessageDialog dialog = new MessageDialog("Prescription has been ordered", "Order was successful");
		Utils.centerWindow(dialog);
		dialog.setModal(true);
		dialog.setVisible(true);
	}
}
