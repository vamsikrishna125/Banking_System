package MAINPACK;

import java.awt.EventQueue;


import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
public class OPENACCOUNT {

	private JFrame frame;
	String s1=null,s2=null,s3=null,s4=null,s6=null,s7=null,s8=null;
	String s5=null;
	private JTextField t1,t2;
	JButton b1,b2;
	JLabel l1,l3,l7;
	private JTextField t3;
	private JLabel lblPin;
	private JTextField t4;
	private JLabel lblMobNo;
	private JTextField t5;
	private JLabel lblEmailId;
	private JTextField t6;
	private JSeparator separator_3;
	private JCheckBox CB1,CB2,CB3,CB4,CB5,CB6;
	
	JLabel imagelbl ;
	String path,source_of_wealth,country_code;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public OPENACCOUNT(String cname) {
		initialize(cname);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String cname) {
		frame = new JFrame();
		frame.setTitle("OPENACCOUNT");
		frame.setBounds(100, 100, 821, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 0, 102));
		panel.setBounds(0, 0, 780, 44);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Personal Details");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_8.setBounds(277, 11, 253, 33);
		panel.add(lblNewLabel_8);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(196, 138, -193, -140);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 46, 780, 418);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		 l1 = new JLabel("User Name");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		l1.setBounds(10, 11, 83, 35);
		panel_2.add(l1);
		
		t1 = new JTextField();
		t1.setBounds(158, 20, 160, 21);
		t1.setText(cname);
		panel_2.add(t1);
		t1.setColumns(10);
		
		l3 = new JLabel("Passport/ID card no");
		l3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		l3.setBounds(10, 57, 151, 29);
		panel_2.add(l3);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(158, 63, 160, 21);
		panel_2.add(t2);
		
		l7 = new JLabel("  Residential Address");
		l7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		l7.setBounds(0, 102, 194, 28);
		panel_2.add(l7);
			
				 b1 = new JButton("Back");
				 b1.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
				 		frame.setVisible(false);
				 		new CustomerRegistration();
				 		
				 	}
				 });
				 b1.setBounds(159, 384, 89, 23);
					panel_2.add(b1);
					
					 b2 = new JButton("Apply");
					 b2.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent e) {
					  try {
								  
			String un,ppn,sow,cc,city,emailid;
			int pin,mobno;
			  un=t1.getText();
			  ppn=t2.getText();
			  sow=source_of_wealth;
			  cc=country_code;
              city=t3.getText();
              pin=Integer.parseInt(t4.getText());
              mobno=Integer.parseInt(t5.getText());
              emailid=t6.getText();
              DbInitialize ob=new DbInitialize();
              ob.useDB();
              int n=ob.insertCustomerExtraDetails2(un,ppn,city,pin, mobno,emailid,sow,cc);
				if(n==1)
					JOptionPane.showMessageDialog(null, " Customer Added");
				else
					JOptionPane.showMessageDialog(null, " Error....");

              
					   }
					   
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}   					 		
	
					 	}
					 });
					 b2.setBounds(289, 384, 89, 23);
						panel_2.add(b2);
								
						JLabel lblCity = new JLabel("City");
						lblCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
						lblCity.setBounds(10, 141, 33, 21);
						panel_2.add(lblCity);
						
						t3 = new JTextField();
						t3.setColumns(10);
						t3.setBounds(103, 143, 83, 21);
						panel_2.add(t3);
						
						lblPin = new JLabel("Pin");
						lblPin.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblPin.setBounds(246, 141, 33, 21);
						panel_2.add(lblPin);
						
						t4 = new JTextField();
						t4.setColumns(10);
						t4.setBounds(289, 143, 83, 21);
						panel_2.add(t4);
						
						lblMobNo = new JLabel("Mob No");
						lblMobNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblMobNo.setBounds(10, 173, 83, 35);
						panel_2.add(lblMobNo);
						
						t5 = new JTextField();
						t5.setColumns(10);
						t5.setBounds(103, 182, 145, 21);
						panel_2.add(t5);
						
						lblEmailId = new JLabel("Email ID");
						lblEmailId.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblEmailId.setBounds(10, 210, 83, 35);
						panel_2.add(lblEmailId);
						
						t6 = new JTextField();
						t6.setColumns(10);
						t6.setBounds(103, 219, 215, 21);
						panel_2.add(t6);
						
						JSeparator separator = new JSeparator();
						separator.setBounds(10, 256, 760, 2);
						panel_2.add(separator);
						
						JSeparator separator_1 = new JSeparator();
						separator_1.setBounds(10, 100, 760, -14);
						panel_2.add(separator_1);
						
						JLabel lblNewLabel = new JLabel("Source of Wealth");
						lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblNewLabel.setBounds(10, 269, 174, 14);
						panel_2.add(lblNewLabel);
						
						 CB2 = new JCheckBox("Inheritance");						
						 CB2.addChangeListener(new ChangeListener() {
							 	public void stateChanged(ChangeEvent e) {
							 		source_of_wealth="Inheritance";
							 	}
							 });
						 CB2.setBounds(217, 290, 118, 23);
							panel_2.add(CB2);
							
							 CB1 = new JCheckBox("Savings");
							 CB1.addChangeListener(new ChangeListener() {
								 	public void stateChanged(ChangeEvent e) {
								 		source_of_wealth="Inheritance";
								 	}
								 });	 

							 CB1.setBounds(49, 290, 97, 23);
								panel_2.add(CB1);
								
								 CB3 = new JCheckBox("Employment");
								 CB3.addChangeListener(new ChangeListener() {
									 	public void stateChanged(ChangeEvent e) {
									 		source_of_wealth="Inheritance";
									 	}
									 });	 

								CB3.setBounds(365, 290, 97, 23);
									panel_2.add(CB3);
								
									CB4 = new JCheckBox("Others");
									CB4.addChangeListener(new ChangeListener() {
									 	public void stateChanged(ChangeEvent e) {
									 		source_of_wealth="Inheritance";
									 	}
									 });	

						 CB4.setBounds(508, 290, 97, 23);
							panel_2.add(CB4);
							ButtonGroup bg=new ButtonGroup();
							bg.add(CB2);
							bg.add(CB1);
							bg.add(CB3);;
						bg.add(CB4);
						JSeparator separator_2 = new JSeparator();
						separator_2.setBounds(10, 320, 688, 20);
						panel_2.add(separator_2);
							
						 imagelbl = new JLabel("    UPLOAD IMAGE HERE");
						 imagelbl.setBorder(new LineBorder(new Color(0, 0, 0)));
						 imagelbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
						imagelbl.setBounds(508, 11, 155, 150);
						panel_2.add(imagelbl);
										
						JButton btnUpload = new JButton("Browse");
						btnUpload.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					JFileChooser fc=new JFileChooser();
			fc.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter=new FileNameExtensionFilter("*.Images","jpg","gif","png");
				fc.addChoosableFileFilter(filter);
				int result=fc.showSaveDialog(null);
			if(result==JFileChooser.APPROVE_OPTION) {
				File Selectedfile=fc.getSelectedFile();
					 path=Selectedfile.getPath();
													
						 ImageIcon myimage=new ImageIcon(path);
						Image img=myimage.getImage();
			Image newimg=img.getScaledInstance(imagelbl.getWidth(),imagelbl.getHeight(),Image.SCALE_SMOOTH);
			ImageIcon ic=new ImageIcon(newimg);
			imagelbl.setIcon(ic);
				}
			else if(result==JFileChooser.CANCEL_OPTION){
			JOptionPane.showInputDialog(null,"No File Choosen");
							}
						}
						});


				btnUpload.setBounds(488, 173, 89, 23);
				panel_2.add(btnUpload);
										
				separator_3 = new JSeparator();
				separator_3.setBounds(10, 95, 502, 2);
				panel_2.add(separator_3);
			CB5 = new JCheckBox("Tick this box if you are not a resident in INDIA for tax purposes or a non India Citizen");
			CB5.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
						country_code="NRI";
									}
							});

				CB5.setBounds(10, 333, 560, 23);
				panel_2.add(CB5);										
		CB6 = new JCheckBox("Tick this box if you are  a resident in INDIA for tax purposes or a  India Citizen");
		CB6.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			country_code="Indian";
				}
			});
		CB6.setBounds(10, 359, 560, 23);
			panel_2.add(CB6);										
		
		ButtonGroup bg2=new ButtonGroup();
		bg2.add(CB5);
		bg2.add(CB6);										
		
		JButton btnUpload_1 = new JButton("Upload");
		btnUpload_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String filename=path;
					File f=new File(filename);
					FileInputStream fis=new FileInputStream(f);
					DbInitialize ob=new DbInitialize();
					ob.useDB();
					int n=ob.insertImage(t1.getText(),fis);
					JOptionPane.showMessageDialog(null, "Image Uploaded"); 
				}catch(Exception ex) {
					System.out.println(ex);
				}
				
			}
		});
		btnUpload_1.setBounds(587, 173, 109, 23);
		panel_2.add(btnUpload_1);
		frame.setVisible(true);
		}
	}


