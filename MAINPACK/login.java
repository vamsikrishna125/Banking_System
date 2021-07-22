package MAINPACK;
import MAINPACK.DbInitialize;
import java.awt.EventQueue;
import MAINPACK.CustomerServices;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class login {

	private JFrame frmWelcome;
	private JTextField tfname;
	private JPasswordField pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmWelcome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws Exception {
		DbInitialize ob=new DbInitialize();
		
		frmWelcome = new JFrame();
		frmWelcome.setTitle("Welcome");
		frmWelcome.getContentPane().setBackground(Color.DARK_GRAY);
		frmWelcome.setBounds(100, 100, 511, 422);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcome.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(new Color(255, 0, 0));
		panel.setBounds(40, 34, 406, 309);
		frmWelcome.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl0 = new JLabel("Welcome User");
		lbl0.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl0.setBounds(119, 29, 173, 14);
		panel.add(lbl0);
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(86, 96, 46, 14);
		panel.add(lblname);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setBounds(86, 147, 63, 14);
		panel.add(lblpassword);
		
		tfname = new JTextField();
		tfname.setBounds(204, 93, 144, 20);
		panel.add(tfname);
		tfname.setColumns(10);
		
		pwd = new JPasswordField();
		pwd.setBounds(204, 144, 144, 20);
		panel.add(pwd);
		
		JButton btnsubmit = new JButton("Submit");
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				try {
			  String s1=tfname.getText();
			  String s2=pwd.getText();
			  ob.useDB();
			  int c=ob.readLogin(s1,s2);
			  if(c==1) {
				  if(s1.equals("presidency")||(s1.equals("sunil"))) {
				  frmWelcome.dispose();
				  new AdminResponse();
			  }
				  else  {
					  frmWelcome.dispose();
					  new CustomerServices(s1);  
				  }
			  }
			 else
				  JOptionPane.showMessageDialog(null, "Invalid Credentials"); 
				}
				catch(Exception e2) {}
			
			}	
		});
		btnsubmit.setBounds(288, 223, 89, 23);
		panel.add(btnsubmit);
	}
}
