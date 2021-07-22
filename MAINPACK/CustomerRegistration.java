package MAINPACK;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class CustomerRegistration {

	private JFrame frmRegistration;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
    String cstreet,ccity,gender,cname,un,pd,dob;;
    private JPasswordField pwd;
    private JPasswordField passwordField;
    
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public CustomerRegistration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistration = new JFrame();
		frmRegistration.setTitle("Registration");
		frmRegistration.setBounds(100, 100, 553, 503);
		frmRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistration.getContentPane().setLayout(null);
		
		JLabel lblCustomerRegistration = new JLabel("Customer Registration");
		lblCustomerRegistration.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCustomerRegistration.setBounds(87, 26, 286, 22);
		frmRegistration.getContentPane().add(lblCustomerRegistration);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(51, 75, 75, 14);
		frmRegistration.getContentPane().add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(51, 119, 75, 14);
		frmRegistration.getContentPane().add(lblLastName);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(51, 168, 75, 14);
		frmRegistration.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(51, 218, 75, 14);
		frmRegistration.getContentPane().add(lblPassword);
		
		JLabel lblRetypePassword = new JLabel("Retype Password");
		lblRetypePassword.setBounds(51, 264, 86, 14);
		frmRegistration.getContentPane().add(lblRetypePassword);
		
		JLabel lblBirthDate = new JLabel("Birth date");
		lblBirthDate.setBounds(51, 306, 86, 14);
		frmRegistration.getContentPane().add(lblBirthDate);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(295, 75, 46, 14);
		frmRegistration.getContentPane().add(lblGender);
		
		JLabel lblState = new JLabel("Street");
		lblState.setBounds(277, 361, 46, 14);
		frmRegistration.getContentPane().add(lblState);
		
		JLabel lblCountry = new JLabel("State");
		lblCountry.setBounds(51, 361, 86, 14);
		frmRegistration.getContentPane().add(lblCountry);
		
		textField = new JTextField();
		textField.setBounds(156, 72, 86, 20);
		frmRegistration.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(156, 116, 86, 20);
		frmRegistration.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(156, 165, 86, 20);
		frmRegistration.getContentPane().add(textField_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(156, 344, 4, 22);
		frmRegistration.getContentPane().add(textArea);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(156, 358, 86, 20);
		comboBox.addItem("Karnataka");
		comboBox.addItem("Andhra Pradesh");
		comboBox.addItem("Tamilnadu");
		comboBox.addItem("Kerala");
		comboBox.addItem("Maharashtra");
		comboBox.addItem("Telangana");
		comboBox.addItem("Odisha");
		comboBox.addItem("West Bengal");
		comboBox.addItem("Bihar");
		comboBox.addItem("Punjab");
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				ccity=(String)arg0.getItem();
			}
		});
		
		frmRegistration.getContentPane().add(comboBox);
		
		
		
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBounds(335, 71, 53, 23);
		frmRegistration.getContentPane().add(rdbtnNewRadioButton);
		
		
		rdbtnNewRadioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				gender="Male";
			}
		});
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(400, 71, 89, 23);
		rdbtnFemale.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				gender="Female";
			}
		});
		
		frmRegistration.getContentPane().add(rdbtnFemale);
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnFemale);
		
		JButton btnSubmit = new JButton("NEXT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegistration.setEnabled(false);
				new OPENACCOUNT(cname);
			}
		});
		btnSubmit.setBounds(384, 430, 89, 23);
		frmRegistration.getContentPane().add(btnSubmit);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(154, 306, 91, 20);
		frmRegistration.getContentPane().add(dateChooser);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmRegistration.setVisible(false);
				new AdminResponse();
			}
		});
		btnBack.setBounds(51, 430, 89, 23);
		frmRegistration.getContentPane().add(btnBack);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				pwd.setText("");
				passwordField.setText("");
				dateChooser.setDate(null);
			}
		});
		btnReset.setBounds(156, 430, 89, 23);
		frmRegistration.getContentPane().add(btnReset);
		
		pwd = new JPasswordField();
		pwd.setBounds(156, 215, 86, 20);
		frmRegistration.getContentPane().add(pwd);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(156, 261, 86, 20);
		frmRegistration.getContentPane().add(passwordField);
		
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(319, 358, 107, 20);
		
		comboBox_2.addItem("Bengaluru");
		comboBox_2.addItem("Indira Nagar");
		comboBox_2.addItem("Hebbal");
		comboBox_2.addItem("Ameerpet");
		comboBox_2.addItem("Pune");
		comboBox_2.addItem("Hyderabad");
		comboBox_2.addItem("Bhubaneswar");
		comboBox_2.addItem("Kolkata");
		comboBox_2.addItem("Patna");
		comboBox_2.addItem("Chandigarh");
		comboBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cstreet=(String)arg0.getItem();
			}
		});
		
		frmRegistration.getContentPane().add(comboBox_2);
		frmRegistration.setVisible(true);
	
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					cname=textField.getText()+" "+textField_1.getText();
					un=cname;
					pd=pwd.getText();
					System.out.println("password:"+pd);
					DbInitialize ob=new DbInitialize();
					ob.useDB();
					int n=ob.insertCustomer(cname, cstreet, ccity);
					System.out.println("VAL N:"+n);
					int p=ob.insertLogin(un, pd);
					System.out.println("VAL P:"+p);
					SimpleDateFormat sd=new SimpleDateFormat("y");
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					String bdate=sdf.format(dateChooser.getDate());
					int q=ob.insertCustomerExtraDetails(un, bdate, gender);
					System.out.println("VAL Q:"+q);
					System.out.println("bdate:"+bdate);
					if(n==1&&p==1&&q==1)
						JOptionPane.showMessageDialog(null, "Insertion Successful"); 
					else 
						JOptionPane.showMessageDialog(null, "Error in Insertion"); 	
					
					
				}catch(Exception ex) {}
				
				
				
			}
		});
		btnSave.setBounds(267, 430, 89, 23);
		frmRegistration.getContentPane().add(btnSave);
		
	}	
}
