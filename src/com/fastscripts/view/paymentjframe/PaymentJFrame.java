package com.fastscripts.view.paymentjframe;

import com.fastscripts.model.domain.Medication;
import com.fastscripts.model.domain.Patient;
import com.fastscripts.model.domain.PersonalData;
import com.fastscripts.model.domain.Prescription;

@SuppressWarnings("serial")
public class PaymentJFrame extends javax.swing.JFrame {

	@SuppressWarnings("unused")
	private PaymentJFrameController paymentJFrameController;
	static Patient patient;
	Patient patientInfo;

	/**
	 * Creates PaymentJFrame
	 */
	public PaymentJFrame(Patient patient) {
		patientInfo = patient;

		if (patient != null) {
			initComponents(patient);
		} else {
			Medication medication = new Medication();
			Prescription perscription = new Prescription();
			perscription.setPrescribedMedication(medication);
			PersonalData personal = new PersonalData();
			Patient patientDefault = new Patient();
			patientDefault.setPatientInfo(personal);
			patientDefault.setPrescription(perscription);
			initComponents(patientDefault);
		}
		paymentJFrameController = new PaymentJFrameController(this);
		this.setSize(550, 360);
		this.setVisible(true);
	}

	/**
	 * Initialize form of the panel
	 */
	private void initComponents(Patient patient) {

		jPanel1 = new javax.swing.JPanel();
		jLabelTitle = new javax.swing.JLabel();

		jLabelPatientFirstName = new javax.swing.JLabel();
		jLabelPatientLastName = new javax.swing.JLabel();
		jLabelPatientDOB = new javax.swing.JLabel();
		jLabelPatientAddress = new javax.swing.JLabel();
		jLabelMedicineType = new javax.swing.JLabel();
		jLabelForm = new javax.swing.JLabel();
		jLabelDose = new javax.swing.JLabel();
		jLabelCount = new javax.swing.JLabel();
		jLabelDosing = new javax.swing.JLabel();
		jLabelInstruction = new javax.swing.JLabel();
		jButtonOrderInsurance = new javax.swing.JButton();
		jButtonOrderPatient = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("FastScripts Order Prescription");
		setFont(new java.awt.Font("Times New Roman", 0, 20));
		getContentPane().setLayout(null);

		jPanel1.setBackground(new java.awt.Color(130, 130, 130));
		jPanel1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jPanel1.setLayout(null);

		jLabelTitle.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelTitle.setText("Patient Prescription");
		jPanel1.add(jLabelTitle);
		jLabelTitle.setBounds(150, 25, 160, 22);

		jLabelPatientFirstName.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelPatientFirstName.setText("First Name:     " + patient.getPatientInfo().getFirstName());
		jPanel1.add(jLabelPatientFirstName);
		jLabelPatientFirstName.setBounds(10, 60, 250, 22);

		jLabelPatientLastName.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelPatientLastName.setText("Last Name:  " + patient.getPatientInfo().getLastName());
		jPanel1.add(jLabelPatientLastName);
		jLabelPatientLastName.setBounds(325, 60, 250, 22);

		jLabelPatientDOB.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelPatientDOB.setText("Date of Birth:  " + patient.getDateOfBirth());
		jPanel1.add(jLabelPatientDOB);
		jLabelPatientDOB.setBounds(10, 90, 250, 22);

		String addressString = "Address:  " + patient.getPatientInfo().getAddress().getAddress() + " "
				+ patient.getPatientInfo().getAddress().getZip() + " " + patient.getPatientInfo().getAddress().getCity()
				+ ", " + patient.getPatientInfo().getAddress().getState();
		jLabelPatientAddress.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelPatientAddress.setText("<html>" + addressString + "</html>");
		jPanel1.add(jLabelPatientAddress);
		jLabelPatientAddress.setBounds(325, 90, 225, 48);

		jLabelMedicineType.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelMedicineType
				.setText("Medicine:  " + patient.getPrescription().getPrescribedMedication().getMedicineType());
		jPanel1.add(jLabelMedicineType);
		jLabelMedicineType.setBounds(10, 120, 280, 22);

		jLabelForm.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelForm.setText("Form:  " + patient.getPrescription().getPrescribedMedication().getForm());
		jPanel1.add(jLabelForm);
		jLabelForm.setBounds(325, 150, 120, 22);

		jLabelDose.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelDose.setText("Dose/day:  " + patient.getPrescription().getDose());
		jPanel1.add(jLabelDose);
		jLabelDose.setBounds(10, 150, 280, 22);

		jLabelDosing.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelDosing.setText("mg/mL per:  " + patient.getPrescription().getDosing());
		jPanel1.add(jLabelDosing);
		jLabelDosing.setBounds(325, 180, 280, 22);

		jLabelCount.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelCount.setText("Count:  " + patient.getPrescription().getCount());
		jPanel1.add(jLabelCount);
		jLabelCount.setBounds(10, 180, 280, 22);

		String instructionString = "Special Instructions:   " + patient.getPrescription().getInstructions();
		jLabelInstruction.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelInstruction.setText("<html>" + instructionString + "</html>");
		jPanel1.add(jLabelInstruction);
		jLabelInstruction.setBounds(10, 180, 400, 88);

		jButtonOrderInsurance.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jButtonOrderInsurance.setText("Order Through Insurance");
		jPanel1.add(jButtonOrderInsurance);
		jButtonOrderInsurance.setBounds(225, 280, 250, 25);

		jButtonOrderPatient.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jButtonOrderPatient.setText("Send Bill to Patient");
		jPanel1.add(jButtonOrderPatient);
		jButtonOrderPatient.setBounds(10, 280, 200, 25);

		getContentPane().add(jPanel1);
		jPanel1.setBounds(0, 0, 600, 320);

		pack();
	}

	/**
	 * 
	 * @return jButtonOrderInsurance
	 */
	public javax.swing.JButton getOrderInsuranceButton() {
		return jButtonOrderInsurance;
	}

	/**
	 * 
	 * @return jButtonOrderPatient
	 */
	public javax.swing.JButton getOrderPatientButton() {
		return jButtonOrderPatient;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				@SuppressWarnings("unused")
				PaymentJFrame paymentJFrame = new PaymentJFrame(patient);
			}
		});
	}

	// Variable declaration
	private javax.swing.JButton jButtonOrderInsurance;
	private javax.swing.JButton jButtonOrderPatient;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel jLabelTitle;
	private javax.swing.JLabel jLabelPatientFirstName;
	private javax.swing.JLabel jLabelPatientLastName;
	private javax.swing.JLabel jLabelPatientDOB;
	private javax.swing.JLabel jLabelPatientAddress;
	private javax.swing.JLabel jLabelMedicineType;
	private javax.swing.JLabel jLabelForm;
	private javax.swing.JLabel jLabelDose;
	private javax.swing.JLabel jLabelCount;
	private javax.swing.JLabel jLabelDosing;
	private javax.swing.JLabel jLabelInstruction;
}
