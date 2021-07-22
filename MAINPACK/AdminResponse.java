package MAINPACK;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminResponse {

	private JFrame frmAdminpanel;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public AdminResponse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminpanel = new JFrame();
		frmAdminpanel.setTitle("AdminPanel");
		frmAdminpanel.getContentPane().setBackground(new Color(0, 255, 255));
		frmAdminpanel.setBounds(100, 100, 564, 296);
		frmAdminpanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminpanel.getContentPane().setLayout(null);
		
		JLabel lblWelcomeAdmistrator = new JLabel("Welcome Administrator");
		lblWelcomeAdmistrator.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblWelcomeAdmistrator.setBounds(140, 22, 311, 29);
		frmAdminpanel.getContentPane().add(lblWelcomeAdmistrator);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(10, 63, 175, 78);
		frmAdminpanel.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton b1 = new JButton("Insert Customer");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAdminpanel.setVisible(false);
				new CustomerRegistration();
				
			}
		});
		b1.setBounds(10, 31, 155, 23);
		panel.add(b1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 20, 147));
		panel_1.setBounds(182, 63, 188, 78);
		frmAdminpanel.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton b2 = new JButton("Fetch Customer");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminpanel.setVisible(false);
				new AllCustomer();
			}
		});
		b2.setBounds(10, 28, 155, 23);
		panel_1.add(b2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(139, 0, 0));
		panel_2.setBounds(370, 63, 175, 78);
		frmAdminpanel.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton b3 = new JButton("Update Customer");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminpanel.setVisible(false);
				new updatecustomer();
			}
		});
		b3.setBounds(10, 29, 155, 23);
		panel_2.add(b3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 255, 0));
		panel_3.setBounds(10, 147, 175, 78);
		frmAdminpanel.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton b4 = new JButton("Delete Customer");
		b4.setBounds(10, 32, 155, 23);
		panel_3.add(b4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.BLUE);
		panel_4.setBounds(185, 147, 185, 78);
		frmAdminpanel.getContentPane().add(panel_4);
		
		JButton btnAddAccount = new JButton("Add Account Details");
		btnAddAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminpanel.setVisible(false);
				new AddAccount();
			}
		});
		btnAddAccount.setBounds(10, 29, 155, 23);
		panel_4.add(btnAddAccount);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.ORANGE);
		panel_5.setBounds(370, 147, 175, 78);
		frmAdminpanel.getContentPane().add(panel_5);
		
		JButton btnAddLoan = new JButton("Add Loan");
		btnAddLoan.setBounds(10, 29, 155, 23);
		panel_5.add(btnAddLoan);
		frmAdminpanel.setVisible(true);
	}
}
