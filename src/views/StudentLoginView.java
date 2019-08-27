package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StudentLoginView extends JFrame{
	

	private JButton loginBtn;
	private static final long serialVersionUID = 1L;

	public StudentLoginView() {
		super("Student");
		
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(300, 200, 80, 30);
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentAddCourseView student = new StudentAddCourseView();
				student.setVisible(true);
				
				StudentLoginView.this.setVisible(false);
				
			}
		});
		panel.add(loginBtn);
		
		this.add(panel);	
	}

}
