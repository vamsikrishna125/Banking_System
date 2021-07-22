package MAINPACK;

import java.awt.EventQueue;
import MAINPACK.DatabaseConnection;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Label;
import javax.swing.JComboBox;

public class updatecustomer {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	String street ,city,name;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public updatecustomer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 448, 361);
		frame.setTitle("update customer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPDATE CUSTOMER DETAILS");
		lblNewLabel.setBounds(122, 21, 204, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("STREET");
		lblNewLabel_1.setBounds(48, 85, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CITY");
		lblNewLabel_1_1.setBounds(48, 120, 46, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(161, 82, 165, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(161, 117, 165, 20);
		frame.getContentPane().add(textField_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(129, 44, 1, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(48, 57, 278, 2);
		frame.getContentPane().add(separator_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(161, 190, 165, 20);
		frame.getContentPane().add(textField_2);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				DbInitialize obj=new DbInitialize();
				obj.useDB();
				street=textField.getText();
			    city=textField_1.getText();
			    name=textField_2.getText();
			    int re=obj.updateCustomer(street, city, name);
			    if(re==1) {
			    	JOptionPane.showMessageDialog(null,"customer details updated successfully!");
			    }
			    else
			    	JOptionPane.showMessageDialog(null,"Invalid credentials!");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			}
		});
		btnNewButton.setBounds(237, 235, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1_3 = new JLabel("Enter u r name to update");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1_3.setBounds(48, 154, 175, 25);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new AdminResponse();
			}
		});
		btnBack.setBounds(75, 235, 89, 23);
		frame.getContentPane().add(btnBack);
		
	}
}
