package JavaAnnotations.university;

import java.util.ArrayList;

public class Professor {

	private int ProfessorID;
	private String name;
	private ArrayList<Advisor> advisors;
	public int getProfessorID() {
		return ProfessorID;
	}
	public void setProfessorID(int professorID) {
		ProfessorID = professorID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Advisor> getAdvisors() {
		return advisors;
	}
	public void setAdvisors(ArrayList<Advisor> advisors) {
		this.advisors = advisors;
	}
	@Override
	public String toString() {
		return "Professor [ProfessorID=" + ProfessorID + ", name=" + name + ", advisors=" + advisors + "]";
	}
	
	
}
