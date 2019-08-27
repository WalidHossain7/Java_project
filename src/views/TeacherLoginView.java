package views;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TeacherLoginView extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TeacherLoginView() {
		super("Teacher");
		
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
	}


}
