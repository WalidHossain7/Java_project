package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import models.Student;

public class StudentLoginView extends JFrame{
	

	private JButton loginBtn, exitBtn;
	private JLabel userLabel, passLabel;
	private JTextField userTF;
	private JPasswordField passPF;
	
	private static final long serialVersionUID = 1L;

	public StudentLoginView() {
		super("Student");
		
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
				
		// Adding values to database starts here //
		String id = userTF.getText().toString();
		String password = passPF.getText();
		Student [] students = new Student[5];
		for ( int i=0; i<students.length; i++) {
			students[i]=new Student();
		}
		System.out.println(students[0].getName());
		int i = 0;
		boolean found = false; // added this variable
		Scanner fileScan = null;
		try {
			String stx = "studentInput";
			fileScan = new Scanner (new File(stx + ".txt"));
			while (fileScan.hasNextLine()) {
			    String input = fileScan.nextLine();
			    System.out.println(input);
			    
			    String[] parts = input.split(",");
			    students[i].setName(parts[0]);
			    students[i].setNsuID(parts[1]);
			    students[i].setPassword(parts[2]);
			    String arb_CGPA = parts[3];
			    students[i].setCGPA(Double.parseDouble(arb_CGPA));
			    i++;
			    if ((students[i].getName().equals(id)) && (students[i].getPassword().equals(password))) {
			      found = true; // added this to set found
			    } // removed the else statement
			  }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(!found) { // added the contents of the previously existing else statement here, outside the while
		    System.out.println("User and Password not found");
		}
		//Taking info from files end here//
		
		// Adding values to database ends here //
		
		
		
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
				String id = userTF.getText().toString();
				if (login(students) != null) {
					Student selected = new Student();
					selected = login(students);
					StudentAddCourseView teacher = new StudentAddCourseView(selected);
					teacher.setVisible(true);
					StudentLoginView.this.setVisible(false);
				}
			}
		});
		panel.add(loginBtn);
		
		this.add(panel);	
	}
	public Student login(Student[] student) {
		//Taking info from files start here//
				Student chosen = null;
				String id = userTF.getText().toString();
				String password = passPF.getText();
				boolean found = false; // added this variable
				int i = 0;
				for (i=0;i<student.length;i++) {
					if (id.equals(student[i].getName()) && password.equals(student[i].getPassword())) {
						chosen = new Student();
						chosen.setName(student[i].getName());
						chosen.setNsuID(student[i].getNsuID());
						chosen.setPassword(student[i].getPassword());
						chosen.setCGPA(student[i].getCGPA());
						found = true;
					}
				}

				if(!found) { // added the contents of the previously existing else statement here, outside the while
				    System.out.println("User and Password not found");
				}
				//Taking info from files end here//
				return chosen;
	}
}

