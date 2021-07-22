package MAINPACK;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Color;

public class depositamount {

	private JFrame frame;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					depositamount window = new depositamount();
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
	public depositamount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("DEPOSIT MONEY");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setBackground(Color.ORANGE);
		lblNewLabel_1.setBounds(125, 29, 185, 14);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setVisible(true);
		/*//lblNewLabel.setIcon(new ImageIcon(depositamount.class.getResource("/Images/federal.png")));
		ImageIcon myimage=new ImageIcon("/Images/federal.png");
		Image img=myimage.getImage();
		ImageIcon ic=new ImageIcon(newimg);
		frame.getContentPane().add(label);
		ImageIcon icon=new ImageIcon("/Images/federal.png");
		Image img=icon.getImage();
		Image newimg=img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon i=new ImageIcon(newimg);
		label.setIcon(i);*/
	}
}
