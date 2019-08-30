package models;

public class Student {

	private String nsuID;
	private String name;
	private String password;
	private double CGPA;
	
	public String getNsuID() {
		return nsuID;
	}
	public void setNsuID(String nsuID) {
		this.nsuID = nsuID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getCGPA() {
		return CGPA;
	}
	public void setCGPA(double CGPA) {
		this.CGPA = CGPA;
	}
	public boolean checkCGPA(double CGPA) {
		if (CGPA >= 2.5) {
			return true;
		} else return false;
	}
}
