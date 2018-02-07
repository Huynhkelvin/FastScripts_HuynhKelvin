package com.fastscripts.view.storeprescriptionjframe;

import com.fastscripts.model.domain.Medication;
import com.fastscripts.model.domain.Patient;
import com.fastscripts.model.domain.PersonalData;
import com.fastscripts.model.domain.Prescription;

public class StorePrescriptionJFrame extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 871L;

	@SuppressWarnings("unused")
	private StorePrescriptionJFrameController storePrescriptionJFrameController;
	static Patient patient;
	Patient patientInfo;

	/**
	 * Creates new instance of storePrescriptionJFrame
	 * 
	 * @param patient
	 */
	public StorePrescriptionJFrame(Patient patient) {

		patientInfo = patient;
		if (patientInfo != null) {
			initComponents(patientInfo);
		} else {
			PersonalData personal = new PersonalData();
			Patient patientDefault = new Patient();
			patientDefault.setPatientInfo(personal);
			initComponents(patientDefault);
		}
		storePrescriptionJFrameController = new StorePrescriptionJFrameController(this);
		this.setSize(800, 350);
		this.setVisible(true);

	}

	/**
	 * Initialize form for storePrescripionJFrame
	 */
	private void initComponents(Patient patient) {
		jPanel1 = new javax.swing.JPanel();
		jLabelTitle = new javax.swing.JLabel();
		jLabelFirst = new javax.swing.JLabel();
		jLabelLast = new javax.swing.JLabel();
		jLabelDOB = new javax.swing.JLabel();
		jLabelPatientFirstName = new javax.swing.JLabel();
		jLabelPatientLastName = new javax.swing.JLabel();
		jLabelPatientDOB = new javax.swing.JLabel();
		jLabelMedicineType = new javax.swing.JLabel();
		jTextFieldMedicineType = new javax.swing.JTextField();
		jLabelForm = new javax.swing.JLabel();
		jTextFieldForm = new javax.swing.JTextField();
		jLabelDose = new javax.swing.JLabel();
		jTextFieldDose = new javax.swing.JTextField();
		jLabelCount = new javax.swing.JLabel();
		jTextFieldCount = new javax.swing.JTextField();
		jLabelDosing = new javax.swing.JLabel();
		jTextFieldDosing = new javax.swing.JTextField();
		jLabelInstruction = new javax.swing.JLabel();
		jTextFieldInstruction = new javax.swing.JTextField();
		jButtonStorePrescription = new javax.swing.JButton();
		jButtonOrderPrescription = new javax.swing.JButton();
		jButtonCancel = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("FastScripts Store Prescription");
		setFont(new java.awt.Font("Times New Roman", 0, 20));
		getContentPane().setLayout(null);

		jPanel1.setBackground(new java.awt.Color(130, 130, 130));
		jPanel1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jPanel1.setLayout(null);

		jLabelTitle.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelTitle.setText("Patient Prescription");
		jPanel1.add(jLabelTitle);
		jLabelTitle.setBounds(150, 25, 160, 22);

		jLabelFirst.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelFirst.setText("First Name:");
		jPanel1.add(jLabelFirst);
		jLabelFirst.setBounds(10, 60, 250, 22);

		jLabelPatientFirstName.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelPatientFirstName.setText(patient.getPatientInfo().getFirstName());
		jPanel1.add(jLabelPatientFirstName);
		jLabelPatientFirstName.setBounds(130, 60, 250, 22);

		jLabelLast.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelLast.setText("Last Name:");
		jPanel1.add(jLabelLast);
		jLabelLast.setBounds(325, 60, 250, 22);

		jLabelPatientLastName.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelPatientLastName.setText(patient.getPatientInfo().getLastName());
		jPanel1.add(jLabelPatientLastName);
		jLabelPatientLastName.setBounds(425, 60, 250, 22);

		jLabelDOB.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelDOB.setText("Date of Birth:");
		jPanel1.add(jLabelDOB);
		jLabelDOB.setBounds(10, 90, 250, 22);

		jLabelPatientDOB.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelPatientDOB.setText(patient.getDateOfBirth());
		jPanel1.add(jLabelPatientDOB);
		jLabelPatientDOB.setBounds(130, 90, 250, 22);

		jLabelMedicineType.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelMedicineType.setText("Medicine:");
		jPanel1.add(jLabelMedicineType);
		jLabelMedicineType.setBounds(325, 90, 120, 22);

		jTextFieldMedicineType.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jTextFieldMedicineType.setText("Medication Name");
		jPanel1.add(jTextFieldMedicineType);
		jTextFieldMedicineType.setBounds(425, 90, 145, 22);

		jLabelForm.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelForm.setText("Form:");
		jPanel1.add(jLabelForm);
		jLabelForm.setBounds(10, 120, 120, 22);

		jTextFieldForm.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jTextFieldForm.setText("Form");
		jPanel1.add(jTextFieldForm);
		jTextFieldForm.setBounds(130, 120, 140, 22);

		jLabelDose.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelDose.setText("Dose/day:");
		jPanel1.add(jLabelDose);
		jLabelDose.setBounds(325, 120, 120, 22);

		jTextFieldDose.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jTextFieldDose.setText("100");
		jPanel1.add(jTextFieldDose);
		jTextFieldDose.setBounds(425, 120, 140, 22);

		jLabelDosing.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelDosing.setText("mg/mL per");
		jPanel1.add(jLabelDosing);
		jLabelDosing.setBounds(10, 150, 120, 22);

		jTextFieldDosing.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jTextFieldDosing.setText("100");
		jPanel1.add(jTextFieldDosing);
		jTextFieldDosing.setBounds(130, 150, 140, 22);

		jLabelCount.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelCount.setText("Count:");
		jPanel1.add(jLabelCount);
		jLabelCount.setBounds(325, 150, 120, 22);

		jTextFieldCount.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jTextFieldCount.setText("100");
		jPanel1.add(jTextFieldCount);
		jTextFieldCount.setBounds(425, 150, 140, 22);

		jLabelInstruction.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelInstruction.setText("Speical Instructions");
		jPanel1.add(jLabelInstruction);
		jLabelInstruction.setBounds(10, 180, 200, 22);

		jTextFieldInstruction.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jTextFieldInstruction.setText("Instructions");
		jPanel1.add(jTextFieldInstruction);
		jTextFieldInstruction.setBounds(10, 200, 500, 22);

		jButtonStorePrescription.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jButtonStorePrescription.setText("Store Prescription");
		jPanel1.add(jButtonStorePrescription);
		jButtonStorePrescription.setBounds(225, 230, 200, 25);

		jButtonOrderPrescription.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jButtonOrderPrescription.setText("Order Prescription");
		jPanel1.add(jButtonOrderPrescription);
		jButtonOrderPrescription.setBounds(445, 230, 200, 25);

		jButtonCancel.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jButtonCancel.setText("Cancel");
		jPanel1.add(jButtonCancel);
		jButtonCancel.setBounds(10, 230, 200, 25);

		getContentPane().add(jPanel1);
		jPanel1.setBounds(0, 0, 800, 350);

		pack();
	}

	/**
	 * 
	 * @return jButtonStorePrescription
	 */
	public javax.swing.JButton getStorePrescriptionButton() {
		return jButtonStorePrescription;
	}

	public javax.swing.JButton getOrderPrescriptionButton() {
		return jButtonOrderPrescription;
	}

	/**
	 * 
	 * @return jButtonCancel
	 */
	public javax.swing.JButton getCancelButton() {
		return jButtonCancel;
	}

	/**
	 * Returns Patient object with the data that was populated by the user
	 * 
	 * @return patient
	 */
	public Patient getStorePrescriptionData(Patient patient) {

		Medication medication = new Medication(jTextFieldMedicineType.getText(), jTextFieldForm.getText());

		Prescription prescription = new Prescription(medication, Integer.parseInt(jTextFieldDose.getText()),
				Integer.parseInt(jTextFieldCount.getText()), Integer.parseInt(jTextFieldDosing.getText()),
				jTextFieldInstruction.getText());

		patientInfo.setPrescription(prescription);

		return patientInfo;
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				@SuppressWarnings("unused")
				StorePrescriptionJFrame storePrescriptionJFrame = new StorePrescriptionJFrame(patient);
			}
		});
	}

	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel jLabelTitle;
	private javax.swing.JButton jButtonStorePrescription;
	private javax.swing.JButton jButtonOrderPrescription;
	private javax.swing.JButton jButtonCancel;
	private javax.swing.JLabel jLabelFirst;
	private javax.swing.JLabel jLabelLast;
	private javax.swing.JLabel jLabelDOB;
	private javax.swing.JLabel jLabelPatientFirstName;
	private javax.swing.JLabel jLabelPatientLastName;
	private javax.swing.JLabel jLabelPatientDOB;
	private javax.swing.JLabel jLabelMedicineType;
	private javax.swing.JLabel jLabelForm;
	private javax.swing.JLabel jLabelDose;
	private javax.swing.JLabel jLabelCount;
	private javax.swing.JLabel jLabelDosing;
	private javax.swing.JLabel jLabelInstruction;
	private javax.swing.JTextField jTextFieldMedicineType;
	private javax.swing.JTextField jTextFieldForm;
	private javax.swing.JTextField jTextFieldDose;
	private javax.swing.JTextField jTextFieldCount;
	private javax.swing.JTextField jTextFieldDosing;
	private javax.swing.JTextField jTextFieldInstruction;
}
