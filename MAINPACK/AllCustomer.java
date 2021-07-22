package MAINPACK;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class AllCustomer {

	private JFrame frmAllcustomer;
	
	private JTable table_1;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public AllCustomer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAllcustomer = new JFrame();
		frmAllcustomer.getContentPane().setBackground(new Color(255, 0, 255));
		frmAllcustomer.setTitle("AllCustomer");
		frmAllcustomer.setBounds(100, 100, 595, 491);
		frmAllcustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAllcustomer.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Image to be Displayed");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		lblNewLabel_1.setBackground(new Color(0, 128, 128));
		lblNewLabel_1.setBounds(441, 304, 117, 114);
		
		frmAllcustomer.getContentPane().add(lblNewLabel_1);
		
		table_1 = new JTable();
		table_1.setBorder(new LineBorder(new Color(255, 0, 0), 3));
		table_1.setBounds(10, 97, 559, 166);
		frmAllcustomer.getContentPane().add(table_1);
		
		JLabel lblEnterUsername = new JLabel("Enter UserName");
		lblEnterUsername.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblEnterUsername.setForeground(new Color(0, 0, 128));
		lblEnterUsername.setBounds(150, 304, 143, 14);
		frmAllcustomer.getContentPane().add(lblEnterUsername);
		
		JLabel lblNewLabel = new JLabel("All Customer Details");
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 24));
		lblNewLabel.setBounds(167, 11, 299, 38);
		frmAllcustomer.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Click");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
					String s="select cust_image from cust_image where customer_name=? ";
					PreparedStatement ps=con.prepareStatement(s);
					String cn=textField.getText();
					ps.setString(1, cn);
					ResultSet rs=ps.executeQuery();
					byte[] i = null;
			        while (rs.next()) {
			            i = rs.getBytes("cust_image");
			        }
			     Image image = Toolkit.getDefaultToolkit().createImage(i);
			        ImageIcon icon = new ImageIcon(image);
			        Image img=icon.getImage();
					Image newimg=img.getScaledInstance(lblNewLabel_1.getWidth(),lblNewLabel_1.getHeight(),Image.SCALE_SMOOTH);
					ImageIcon ic=new ImageIcon(newimg);
					lblNewLabel_1.setIcon(ic);
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex);
					}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setForeground(new Color(0, 128, 0));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(342, 348, 89, 23);
		frmAllcustomer.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAllcustomer.setVisible(false);
				new AdminResponse();
			}
		});
		btnBack.setBounds(74, 398, 76, 23);
		frmAllcustomer.getContentPane().add(btnBack);
		
		JLabel lblCustname = new JLabel("CUST_NAME");
		lblCustname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustname.setBounds(36, 72, 97, 14);
		frmAllcustomer.getContentPane().add(lblCustname);
		
		JLabel lblCuststreet = new JLabel("CUST_STREET");
		lblCuststreet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCuststreet.setBounds(212, 74, 111, 14);
		frmAllcustomer.getContentPane().add(lblCuststreet);
		
		JLabel lblCustcity = new JLabel("CUST_CITY");
		lblCustcity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustcity.setBounds(400, 74, 97, 14);
		frmAllcustomer.getContentPane().add(lblCustcity);
		
		textField = new JTextField();
		textField.setBounds(303, 304, 117, 20);
		frmAllcustomer.getContentPane().add(textField);
		textField.setColumns(10);
		
		frmAllcustomer.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				try {
					try {
						DbInitialize ob=new DbInitialize();
						ob.useDB();
						ResultSet rs=ob.readCustomer();
						
						table_1.setModel(DbUtils.resultSetToTableModel(rs));
					}catch(Exception ex) {}
								
				}catch(Exception ex) {
					System.out.println(ex);
				}
				
			}
			
			
		});
		
		frmAllcustomer.setVisible(true);
	}
}
