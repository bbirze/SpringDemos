package university;

import university.Advisor;

public class Student {
	
	private int studentID;
	private String name;
	private double gpa;
	private Advisor advisor;
	
	public Student()  {}
	
	public Student(Advisor advisor)  {
		this.advisor = advisor;
	}
	
	public void init()  {
		System.out.println("in init method");
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
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

	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", name=" + name + ", gpa=" + gpa + "\n   advisor=" + advisor + "]";
	}
	
	
	

}
