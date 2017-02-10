package di.university;

import di.university.Advisor;

public class Student {
	
	private int id;
	private String name;
	private double gpa;
	private Advisor theAdvisor;
	
	public Student() {}
	
	public Student(String name, Advisor advisor) {
		super();
		this.name = name;
		this.theAdvisor = advisor;
	}

	public Student(int studentID, double gpa) {
		super();
		this.id = studentID;
		this.gpa = gpa;
	}


	public void init()  {
		System.out.println("in init method");
	}

	public int getId() {
		return id;
	}

	public void setId(int studentID) {
		this.id = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	private Advisor getTheAdvisor() {
		return theAdvisor;
	}

	public void setTheAdvisor(Advisor advisor) {
		this.theAdvisor = advisor;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + id + ", name=" + name + ", gpa=" + gpa + "\n   advisor=" + theAdvisor + "]";
	}
	
	
	

}
