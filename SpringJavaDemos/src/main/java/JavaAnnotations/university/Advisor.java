package university;

import java.util.ArrayList;
import java.util.Collection;

import university.Professor;
import university.Student;

public class Advisor {
	private int AdvisorID;
	private String name;
	private double salary;
	private Professor theProf;
	
	private Collection<Student> students = new ArrayList<>();

	public int getAdvisorID() {
		return AdvisorID;
	}

	public void setAdvisorID(int advisorID) {
		AdvisorID = advisorID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Professor getTheProf() {
		return theProf;
	}

	public void setTheProf(Professor theProf) {
		this.theProf = theProf;
	}

	public Collection<Student> getStudents() {
		return students;
	}

	public void setStudents(Collection<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Advisor [AdvisorID=" + AdvisorID + ", name=" + name + ", salary=" + salary + "\n   theProf=" + theProf
				+ "\n        students=" + students + "]";
	}
	
	

}
