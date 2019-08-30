package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TeacherLoginView extends JFrame{

	private JButton loginBtn, exitBtn;
	private JLabel userLabel, passLabel;
	private JTextField userTF;
	private JPasswordField passPF;
	
	private static final long serialVersionUID = 1L;

	public TeacherLoginView() {
		super("Teacher");
		
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(300, 100, 60, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(370, 100, 100, 30);
		panel.add(userTF);
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(300, 150, 70, 30);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(370, 150, 100, 30);
		passPF.setEchoChar('*');
		panel.add(passPF);
				
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(390, 200, 80, 30);
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		panel.add(exitBtn);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(300, 200, 80, 30);
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		
				
				if (login() == true) {
					TeacherAddCourseView teacher = new TeacherAddCourseView();
					teacher.setVisible(true);
					
					TeacherLoginView.this.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(TeacherLoginView.this,"Sorry, username or password error!");
				}
			}
		});
		panel.add(loginBtn);
		
		
		this.add(panel);
	}
	
	public boolean login() {
		//Taking info from files start here//
				String id = userTF.getText().toString();
				String password = passPF.getText();
				
				boolean found = false; // added this variable
				
				Scanner fileScan = null;
				
				try {
					fileScan = new Scanner (new File("teacherInput.txt"));
					
					while (fileScan.hasNextLine()) {
					    String input = fileScan.nextLine();
					    String Username = input.substring(0, input.indexOf(','));
					    String Password = input.substring(input.indexOf(',')+1,input.length());
					    
					    if ((Username.equals(id)) && (Password.equals(password))) {
					      found = true; 
					    } 
					  }
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				  if(!found) { 
				    System.out.println("User and Password not found");
				  }
				
				return found;
	}


}