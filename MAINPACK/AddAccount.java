package MAINPACK;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddAccount {

	private JFrame frmAdminPanel;
	private JTextField cn;
	private JTextField acc;
	private JTextField bn;
	private JTextField balance;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public AddAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminPanel = new JFrame();
		frmAdminPanel.getContentPane().setBackground(new Color(255, 255, 255));
		frmAdminPanel.setTitle("Admin Panel");
		frmAdminPanel.setBounds(100, 100, 423, 328);
		frmAdminPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminPanel.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DbInitialize ob = new DbInitialize();
					ob.useDB();
					int p=ob.insertAccount(Integer.parseInt(acc.getText()),bn.getText(),Double.parseDouble(balance.getText()));
					int q=ob.insertDepositor(cn.getText(),Integer.parseInt(acc.getText()));
					
					if(p==1&&q==1)
						JOptionPane.showMessageDialog(null, "Insertion Successful"); 
					else 
						JOptionPane.showMessageDialog(null, "Error in Insertion"); 	
				}catch(Exception ex) {}
				
			}
		});
		btnNewButton.setBounds(258, 239, 89, 23);
		frmAdminPanel.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminPanel.setVisible(false);
				new AdminResponse();
			}
		});
		btnBack.setBounds(71, 239, 89, 23);
		frmAdminPanel.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Customer Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(71, 51, 108, 14);
		frmAdminPanel.getContentPane().add(lblNewLabel);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAccountNumber.setBounds(71, 96, 108, 14);
		frmAdminPanel.getContentPane().add(lblAccountNumber);
		
		JLabel lblBranchName = new JLabel("Branch Name");
		lblBranchName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBranchName.setBounds(71, 138, 89, 14);
		frmAdminPanel.getContentPane().add(lblBranchName);
		
		JLabel lblOpeningBalance = new JLabel("Opening Balance");
		lblOpeningBalance.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOpeningBalance.setBounds(63, 181, 97, 14);
		frmAdminPanel.getContentPane().add(lblOpeningBalance);
		
		cn = new JTextField();
		cn.setBounds(203, 49, 133, 20);
		frmAdminPanel.getContentPane().add(cn);
		cn.setColumns(10);
		
		acc = new JTextField();
		acc.setColumns(10);
		acc.setBounds(203, 96, 133, 20);
		frmAdminPanel.getContentPane().add(acc);
		
		bn = new JTextField();
		bn.setColumns(10);
		bn.setBounds(203, 136, 133, 20);
		frmAdminPanel.getContentPane().add(bn);
		
		balance = new JTextField();
		balance.setColumns(10);
		balance.setBounds(203, 179, 133, 20);
		frmAdminPanel.getContentPane().add(balance);
		frmAdminPanel.setVisible(true);
	}

}
