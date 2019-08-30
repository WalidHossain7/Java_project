package models;

public class Teacher {
	
	private String nsuID;
	private String name;
	private String password;
	private double salary;
	
	public Teacher() {
		this.name = "";
		this.nsuID = "";
		this.password = "";
		this.salary = 0.0;
	}
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
