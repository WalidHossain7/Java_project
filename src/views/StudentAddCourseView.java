package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import models.Course;
import models.Student;

public class StudentAddCourseView extends JFrame{
	
	private JTable courseTable;
	private JScrollPane courseTableSP;
	private JLabel studentName, studentID, studentCGPA;
	private JLabel studentNameData, studentIDData, studentCGPAData;
	private JLabel courseIdLabel, courseCreditLabel, courseNameLabel;
	private JTextField courseIdTF, courseNameTF, courseCreditTF;
	private JButton addBtn, updateBtn, deleteBtn, backBtn, getAllBtn;
	private static final long serialVersionUID = 1L;
	private static int maxCount = 0;
	
	public StudentAddCourseView(Student student) {
		super("Student Add Course");
		
		int limit = 0;
		
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		Course[] courses = new Course[5];
		for (int i=0; i<courses.length; i++) {
			courses[i]=new Course();
		}
		int i = 0;
		Scanner fileScan = null;
		try {
			String stx = student.getName();
			fileScan = new Scanner (new File(stx + ".txt"));
			while (fileScan.hasNextLine()) {
			    String input = fileScan.nextLine();
			    System.out.println(input);
			    
			    String[] parts = input.split(",");
			    courses[i].setCourseCode(parts[0]);
			    courses[i].setCourseName(parts[1]);
			    
			    String arb_credit = parts[2];
			    courses[i].setCourseCredit(Integer.parseInt(arb_credit));
			    i++;
			    maxCount++;
			  }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String data[][] = {{"", "", ""}};
		
		String head[] = {"Index", "Course Code", "Credit"};
		
		courseTable = new JTable(data,head);
		courseTableSP = new JScrollPane(courseTable);
		courseTableSP.setBounds(350, 100, 400, 150);
		courseTable.setEnabled(false);
		panel.add(courseTableSP);
		if (courseTable.getCellSelectionEnabled()) {
		      courseTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		      int rowIndex = courseTable.getSelectedRow();
		      int colIndex = courseTable.getSelectedColumn();
		 }
		
		
		studentName = new JLabel("Student :");
		studentName.setBounds(100,75,100,30);
		panel.add(studentName);
		
		studentNameData = new JLabel(student.getName());
		studentNameData.setBounds(220,75,100,30);
		panel.add(studentNameData);
		
		studentID = new JLabel("ID :");
		studentID.setBounds(100,50,100,30);
		panel.add(studentID);
		
		studentIDData = new JLabel(student.getNsuID());
		studentIDData.setBounds(220,50,100,30);
		panel.add(studentIDData);
		
		courseIdLabel = new JLabel("Course Code :");
		courseIdLabel.setBounds(100,100,100,30);
		panel.add(courseIdLabel);
		
		courseIdTF = new JTextField();
		courseIdTF.setBounds(220,100,100,30);
		panel.add(courseIdTF);
		
		courseNameLabel = new JLabel("Course Name :");
		courseNameLabel.setBounds(100,150,100,30);
		panel.add(courseNameLabel);
		
		courseNameTF = new JTextField();
		courseNameTF.setBounds(220,150,100,30);
		panel.add(courseNameTF);
		
		courseCreditLabel = new JLabel("Course Credit: ");
		courseCreditLabel.setBounds(100,200,100,30);
		panel.add(courseCreditLabel);
		
		courseCreditTF = new JTextField();
		courseCreditTF.setBounds(220,200,100,30);
		panel.add(courseCreditTF);
		
		studentCGPA = new JLabel("CGPA :");
		studentCGPA.setBounds(100,250,100,30);
		panel.add(studentCGPA);
		
		studentCGPAData = new JLabel(String.valueOf(student.getCGPA()));
		studentCGPAData.setBounds(220,250,100,30);
		panel.add(studentCGPAData);
		
		addBtn = new JButton("ADD");
		addBtn.setBounds(100,300,80,30);
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String data[][] = {{"", "", ""}, {"", "", ""}, {"", "", ""}, {"", "", ""}, {"", "", ""}};
				String head[] = {"Index", "Course Code", "Credit"};
				courses[maxCount].setCourseCode(courseIdTF.getText());
				courses[maxCount].setCourseName(courseNameTF.getText());
				courses[maxCount].setCourseCredit(Integer.parseInt(courseCreditTF.getText()));
				maxCount++;
				for (int j=0; j<data.length; j++) {
					data[j][0] = courses[j].getCourseCode();
					data[j][1] = courses[j].getCourseName();
					data[j][2] = Integer.toString(courses[j].getCourseCredit());
				}
				System.out.println(maxCount);
				
				
				courseTable = new JTable(data,head);
				courseTableSP = new JScrollPane(courseTable);
				courseTableSP.setBounds(350, 100, 400, 150);
				courseTable.setEnabled(false);
				panel.add(courseTableSP);
				if (courseTable.getCellSelectionEnabled()) {
				      courseTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				      int rowIndex = courseTable.getSelectedRow();
				      int colIndex = courseTable.getSelectedColumn();
				 }
				
			}
		});
		panel.add(addBtn);
		
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(200,300,80,30);
		updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Scanner fileScan = null;
				try {
					String stx = student.getName();
					File fout = new File(stx + ".txt");
					FileOutputStream fos = new FileOutputStream(fout);
					 
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
					for (int k=0;k<maxCount;k++) {
						try {
							bw.write(courses[k].getCourseCode()+","+courses[k].getCourseName()+","+courses[k].getCourseCredit());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							bw.newLine();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} 
					try {
						bw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		updateBtn.setEnabled(true);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(300,300,80,30);
		deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		deleteBtn.setEnabled(true);
		panel.add(deleteBtn);
		
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(500,300,80,30);
		getAllBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int maxCount = 0;
				String data[][] = {{"", "", ""}, {"", "", ""}, {"", "", ""}, {"", "", ""}, {"", "", ""}};
				for (int j=0; j<data.length; j++) {
					data[j][0] = courses[j].getCourseCode();
					data[j][1] = courses[j].getCourseName();
					data[j][2] = Integer.toString(courses[j].getCourseCredit());
				}
				String head[] = {"Index", "Course Code", "Credit"};
				
				courseTable = new JTable(data,head);
				courseTableSP = new JScrollPane(courseTable);
				courseTableSP.setBounds(350, 100, 400, 150);
				courseTable.setEnabled(false);
				panel.add(courseTableSP);
				if (courseTable.getCellSelectionEnabled()) {
				      courseTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				      int rowIndex = courseTable.getSelectedRow();
				      int colIndex = courseTable.getSelectedColumn();
				 }
			}
		});
		panel.add(getAllBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 350, 80, 30);
		backBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentLoginView student= new StudentLoginView();
				student.setVisible(true);
				
				StudentAddCourseView.this.setVisible(false);
				
			}
		});
		panel.add(backBtn);
		
		this.add(panel);
	}

}
