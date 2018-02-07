package com.fastscripts.view.mainjframe;

import com.fastscripts.model.domain.Patient;
import com.fastscripts.model.domain.PersonalData;

public class MainJFrame extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates PatientJFrame
	 */
	public MainJFrame() {
		initComponents();

		this.setSize(450, 260);
		this.setVisible(true);
	}

	/**
	 * Initialize form of the panel
	 */
	private void initComponents() {

		jMenuBar = new javax.swing.JMenuBar();
		setJMenuBar(jMenuBar);
		jFileMenu = new javax.swing.JMenu();
		jDataMenu = new javax.swing.JMenu();
		jFileMenuItem = new javax.swing.JMenuItem();
		jPanel1 = new javax.swing.JPanel();
		jLabelTitle = new javax.swing.JLabel();
		jLabelPatientFirstName = new javax.swing.JLabel();
		jTextFieldPatientFirstName = new javax.swing.JTextField();
		jLabelPatientLastName = new javax.swing.JLabel();
		jTextFieldPatientLastName = new javax.swing.JTextField();
		jLabelPatientDOB = new javax.swing.JLabel();
		jTextFieldPatientDOB = new javax.swing.JTextField();
		jButtonStorePrescription = new javax.swing.JButton();

		jMenuBar.setOpaque(false);

		jFileMenu.setText("File");
		jFileMenu.setFont(new java.awt.Font("Times New Roman", 0, 10));

		jDataMenu.setText("Import Data");
		jDataMenu.setFont(new java.awt.Font("Times New Roman", 0, 10));

		jFileMenuItem.setText("Load Patient file");
		jFileMenuItem.setFont(new java.awt.Font("Times New Roman", 0, 10));
		jDataMenu.add(jFileMenuItem);

		jFileMenu.add(jDataMenu);
		jMenuBar.add(jFileMenu);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("FastScripts");
		setFont(new java.awt.Font("Times New Roman", 0, 20));
		getContentPane().setLayout(null);

		jPanel1.setBackground(new java.awt.Color(130, 130, 130));
		jPanel1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jPanel1.setLayout(null);

		jLabelTitle.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelTitle.setText("Patient Information");
		jPanel1.add(jLabelTitle);
		jLabelTitle.setBounds(150, 25, 160, 22);

		jLabelPatientFirstName.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelPatientFirstName.setText("First Name:");
		jPanel1.add(jLabelPatientFirstName);
		jLabelPatientFirstName.setBounds(10, 60, 120, 22);

		jTextFieldPatientFirstName.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jTextFieldPatientFirstName.setText("Kelvin");
		jPanel1.add(jTextFieldPatientFirstName);
		jTextFieldPatientFirstName.setBounds(125, 60, 90, 22);

		jLabelPatientLastName.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelPatientLastName.setText("Last Name:");
		jPanel1.add(jLabelPatientLastName);
		jLabelPatientLastName.setBounds(10, 85, 120, 22);

		jTextFieldPatientLastName.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jTextFieldPatientLastName.setText("Huynh");
		jPanel1.add(jTextFieldPatientLastName);
		jTextFieldPatientLastName.setBounds(125, 85, 90, 22);

		jLabelPatientDOB.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jLabelPatientDOB.setText("Date of Birth:");
		jPanel1.add(jLabelPatientDOB);
		jLabelPatientDOB.setBounds(10, 110, 120, 22);

		jTextFieldPatientDOB.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jTextFieldPatientDOB.setText("08/21/2015");
		jPanel1.add(jTextFieldPatientDOB);
		jTextFieldPatientDOB.setBounds(125, 110, 140, 22);

		jButtonStorePrescription.setFont(new java.awt.Font("Times New Roman", 0, 20));
		jButtonStorePrescription.setText("Store Prescription");
		jPanel1.add(jButtonStorePrescription);
		jButtonStorePrescription.setBounds(225, 170, 200, 25);

		getContentPane().add(jPanel1);
		jPanel1.setBounds(0, 0, 450, 205);

		pack();
	}

	public javax.swing.JMenuItem getFileMenuItem() {
		return jFileMenuItem;
	}

	/**
	 * 
	 * @return jButtonStorePrescription
	 */
	public javax.swing.JButton getStorePrescriptionButton() {
		return jButtonStorePrescription;
	}

	/**
	 * Returns Patient object that was populated with user entered data
	 * 
	 * @return patient
	 */
	public Patient getPatientData() {
		PersonalData patientInfo = new PersonalData(jTextFieldPatientFirstName.getText(),
				jTextFieldPatientLastName.getText());

		Patient patient = new Patient(patientInfo, jTextFieldPatientDOB.getText());
		return patient;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				@SuppressWarnings("unused")
				MainJFrame patientDataJFrame = new MainJFrame();

			}
		});
	}

	// Variable declaration
	private javax.swing.JMenuBar jMenuBar;
	private javax.swing.JMenu jDataMenu;
	private javax.swing.JMenu jFileMenu;
	private javax.swing.JMenuItem jFileMenuItem;
	private javax.swing.JButton jButtonStorePrescription;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel jLabelTitle;
	private javax.swing.JLabel jLabelPatientFirstName;
	private javax.swing.JLabel jLabelPatientLastName;
	private javax.swing.JLabel jLabelPatientDOB;
	private javax.swing.JTextField jTextFieldPatientFirstName;
	private javax.swing.JTextField jTextFieldPatientLastName;
	private javax.swing.JTextField jTextFieldPatientDOB;
}
