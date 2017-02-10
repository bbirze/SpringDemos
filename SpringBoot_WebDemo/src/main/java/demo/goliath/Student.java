package demo.goliath;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	private int studentId;
	private String name;
	private double gpa;
	
	public Student()  {}

	public Student(int studentId, String name, double gpa) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.gpa = gpa;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", gpa=" + gpa + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student)obj;
		if (studentId != other.studentId)
			return false;
		
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + studentId;
		return result;
	}

	

}
