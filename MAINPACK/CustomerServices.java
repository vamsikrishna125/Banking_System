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

public class CustomerServices {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public CustomerServices(String un) {
		initialize(un);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String un) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(224, 255, 255));
		frame.setBounds(100, 100, 547, 281);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(136, 40, 281, 22);
		lblNewLabel.setText(lblNewLabel.getText()+" "+un);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(10, 85, 175, 78);
		frame.getContentPane().add(panel);
		
		JButton btnCheckDetails = new JButton("Check Details");
		btnCheckDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new CustomerDetails(un);
			}
		});
		btnCheckDetails.setBounds(10, 31, 155, 23);
		panel.add(btnCheckDetails);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 0, 255));
		panel_1.setBounds(183, 85, 175, 78);
		frame.getContentPane().add(panel_1);
		
		JButton btnDepositAmount = new JButton("Deposit Amount");
		btnDepositAmount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new depositamount();
			}
		});
		btnDepositAmount.setBounds(10, 31, 155, 23);
		panel_1.add(btnDepositAmount);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 191, 255));
		panel_2.setBounds(352, 85, 175, 78);
		frame.getContentPane().add(panel_2);
		
		JButton btnTransferMoney = new JButton("Transfer Money");
		btnTransferMoney.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new transfermoney();
				
			}
		});
		btnTransferMoney.setBounds(10, 31, 155, 23);
		panel_2.add(btnTransferMoney);
		frame.setVisible(true);
	}

}
