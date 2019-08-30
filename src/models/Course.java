package models;

public class Course {
	private String courseCode;
	private String courseName;
	private int courseCredit;
	
	public Course() {
		this.courseCode = "";
		this.courseName = "";
		this.courseCredit = 0;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseCredit() {
		return courseCredit;
	}
	public void setCourseCredit(int courseCredit) {
		this.courseCredit = courseCredit;
	}

	
}
