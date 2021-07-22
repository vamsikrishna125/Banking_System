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
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class fetchaccount_details {

	private JFrame frame;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fetchaccount_details window = new fetchaccount_details();
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
	public fetchaccount_details() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 489, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 38, 468, 217);
		frame.getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("ACCOUNT DETAILS");
		lblNewLabel.setForeground(new Color(107, 142, 35));
		//lblNewLabel.setBorder(new LineBorder(color));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(159, 1, 123, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("      Image to be displayed");
		lblNewLabel_2.setLabelFor(frame);
		lblNewLabel_2.setToolTipText("IMAGE");
		lblNewLabel_2.setBackground(new Color(255, 200, 0));
		lblNewLabel_2.setForeground(new Color(0, 139, 139));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(159, 288, 142, 133);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(169, 432, 132, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
					
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
						String s="select customer_name,cust_image from cust_image where customer_name in (select cust_name from depositor where accno=?)";
						PreparedStatement ps=con.prepareStatement(s);
						int acno=Integer.parseInt(textField.getText());
						ps.setInt(1, acno);
						ResultSet rs=ps.executeQuery();
						byte[] i = null;
						String cname = null;
				        while (rs.next()) {
				            cname=rs.getString(1);
				            i = rs.getBytes("cust_image");
				        }
						lblNewLabel_3.setText(cname);
				     Image image = Toolkit.getDefaultToolkit().createImage(i);
				        ImageIcon icon = new ImageIcon(image);
				        Image img=icon.getImage();
						Image newimg=img.getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight(),Image.SCALE_SMOOTH);
						ImageIcon ic=new ImageIcon(newimg);
						lblNewLabel_2.setIcon(ic);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "please upload image!!!...");
					}
			}
		});
		btnNewButton.setBounds(360, 266, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Enter account number:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(10, 263, 153, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(149, 266, 181, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
	
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				try {
					try {
						DbInitialize ob=new DbInitialize();
						ob.useDB();
						ResultSet rs=ob.readAccount();
						
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}catch(Exception ex) {}
								
				}catch(Exception ex) {
					//System.out.println(ex);
				}
				
			}
			
			
		});
		
		frame.setVisible(true);
	}
}
