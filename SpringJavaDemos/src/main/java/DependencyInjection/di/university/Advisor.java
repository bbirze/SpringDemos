package DependencyInjection.di.university;

public class Advisor {
	private String name;
	private double salary;
	
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

	@Override
	public String toString() {
		return "Advisor [name=" + name + ", salary=" + salary + "]";
	}

	

}
