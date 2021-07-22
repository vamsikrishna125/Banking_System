package MAINPACK;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class transfermoney {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
    String racno,amount;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					transfermoney window = new transfermoney();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public transfermoney() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 455, 351);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TRANSFER MONEY");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(134, 11, 196, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SENDER NAME");
		lblNewLabel_1.setBounds(49, 57, 137, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("SENDER ACCNO");
		lblNewLabel_1_1.setBounds(49, 93, 137, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("RECEIVER ACCNO");
		lblNewLabel_1_2.setBounds(49, 130, 137, 14);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("AMOUNT");
		lblNewLabel_1_3.setBounds(49, 161, 97, 14);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		textField = new JTextField();
		textField.setBounds(214, 54, 137, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(214, 90, 137, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(214, 127, 137, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(214, 158, 137, 20);
		frame.getContentPane().add(textField_3);
		
		JButton btnNewButton = new JButton("TRANSFER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DbInitialize obj;
				try {
					obj = new DbInitialize();
					obj.useDB();
					racno=textField_2.getText();
					int no=Integer.parseInt(racno);
					amount=textField_3.getText();
					int amnt=Integer.parseInt(amount);
					int sno=Integer.parseInt(textField_1.getText()); 
					int re=obj.transfer_money(sno,no, amnt);
					if(re==1)
						JOptionPane.showMessageDialog(null,"TRANSFER SUCCESSFUL!");
					else
						JOptionPane.showMessageDialog(null,"TRANSFER FAILED!");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(214, 208, 129, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String sname=textField.getText();
				frame.setVisible(false);
				new CustomerServices(sname);
			}
		});
		btnBack.setBounds(49, 208, 129, 23);
		frame.getContentPane().add(btnBack);
	}
}
