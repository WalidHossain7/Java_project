package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class StudentAddCourseView extends JFrame{
	
	private JTable courseTable;
	private JScrollPane courseTableSP;
	private JLabel courseIdLabel, courseCreditLabel, courseNameLabel;
	private JTextField courseIdTF, courseNameTF, courseCreditTF;
	private JButton addBtn, updateBtn, deleteBtn, backBtn, getAllBtn;
	private static final long serialVersionUID = 1L;

	public StudentAddCourseView() {
		super("Student Add Course");
		
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
				
		String data[][] = {{"", "", "", ""}};
		
		String head[] = {"index", "Course Code", "Credit"};
		
		courseTable = new JTable(data,head);
		courseTableSP = new JScrollPane(courseTable);
		courseTableSP.setBounds(350, 100, 400, 150);
		courseTable.setEnabled(false);
		panel.add(courseTableSP);
		
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
		
		addBtn = new JButton("ADD");
		addBtn.setBounds(100,300,80,30);
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		panel.add(addBtn);
		
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(200,300,80,30);
		updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(300,300,80,30);
		deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(500,300,80,30);
		getAllBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
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
