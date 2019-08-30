package models;

public class PermanentFaculty extends Teacher {
	

	private static int limit = 7; 

	@Override
	public String getNsuID() {
		// TODO Auto-generated method stub
		return super.getNsuID();
	}

	@Override
	public void setNsuID(String nsuID) {
		// TODO Auto-generated method stub
		super.setNsuID(nsuID);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}
	
	@Override
	public double getSalary() {
		// TODO Auto-generated method stub
		return super.getSalary();
	}

	@Override
	public void setSalary(double salary) {
		// TODO Auto-generated method stub
		super.setSalary(7000);
	}
}
