package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginView extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1966934171369599039L;
	private JButton studentLoginBtn, teacherLoginBtn;

	public LoginView() {
		
		super("Login Window");
		
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel title = new JLabel("Log in as");
		title.setBounds(300, 50, 350, 30);
		panel.add(title);
		
		
		studentLoginBtn = new JButton("Student");
		studentLoginBtn.setBounds(200, 200, 80, 30);
		studentLoginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentLoginView student = new StudentLoginView();
				student.setVisible(true);
				
				LoginView.this.setVisible(false);
				
			}
		});
		
		
		panel.add(studentLoginBtn);
		
		
		teacherLoginBtn = new JButton("Teacher");
		teacherLoginBtn.setBounds(300, 200, 100, 30);
		teacherLoginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TeacherLoginView teacher = new TeacherLoginView();
				teacher.setVisible(true);
				
				LoginView.this.setVisible(false);
				
			}
		});
		panel.add(teacherLoginBtn);
		
		JButton exitBtn = new JButton("Exit");
		exitBtn.setBounds(500, 200, 80, 30);
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		panel.add(exitBtn);
		
		
		
		this.add(panel);		
	}



}
