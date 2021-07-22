package MAINPACK;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerDetails {

	private JFrame frmCustomerdetails;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public CustomerDetails(String cn) {
		initialize(cn);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String cn) {
		frmCustomerdetails = new JFrame();
		frmCustomerdetails.getContentPane().setBackground(new Color(255, 255, 255));
		frmCustomerdetails.setTitle("CustomerDetails");
		frmCustomerdetails.setBounds(100, 100, 483, 400);
		frmCustomerdetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCustomerdetails.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(41, 35, 304, 14);
		frmCustomerdetails.getContentPane().add(lblName);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAccountNumber.setBounds(41, 79, 304, 14);
		frmCustomerdetails.getContentPane().add(lblAccountNumber);
		
		JLabel lblBranch = new JLabel("Branch Name");
		lblBranch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBranch.setBounds(41, 131, 304, 14);
		frmCustomerdetails.getContentPane().add(lblBranch);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBalance.setBounds(41, 181, 304, 14);
		frmCustomerdetails.getContentPane().add(lblBalance);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCustomerdetails.setVisible(false);
				new CustomerServices(cn);
			}
		});
		btnNewButton.setBounds(189, 311, 89, 23);
		frmCustomerdetails.getContentPane().add(btnNewButton);
		frmCustomerdetails.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				lblName.setText(lblName.getText()+"----- "+cn);
				try {
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
				PreparedStatement ps=con.prepareStatement("select accno from depositor where cust_name=?");
				ps.setString(1, cn);
				ResultSet rs=ps.executeQuery();
				int accno=0;
				while(rs.next()) {
					accno=rs.getInt(1);
				}
				lblAccountNumber.setText(lblAccountNumber.getText()+"----"+String.valueOf(accno));
				
				
				ps=con.prepareStatement("select br_name,balance from account where accno=?");
				ps.setInt(1, accno);
				 rs=ps.executeQuery();
				String bnm="";
				double blnc=0;
				while(rs.next()) {
					bnm=rs.getString(1);
					blnc=rs.getDouble(2);
				}
				lblBranch.setText(lblBranch.getText()+"---"+bnm);
				lblBalance.setText(lblBalance.getText()+"----"+String.valueOf(blnc));
				}catch(Exception ex) {}
				
			}
		});
		
		
		frmCustomerdetails.setVisible(true);
	}

}
