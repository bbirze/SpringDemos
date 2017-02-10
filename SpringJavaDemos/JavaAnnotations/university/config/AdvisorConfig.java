package university.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import university.Advisor;
import university.Professor;

@Configuration
public class AdvisorConfig {

	@Bean
	public Advisor myAdvisor()  {
		Advisor a = new Advisor();
		a.setAdvisorID(12);
		a.setName("Sue Smith");
		a.setSalary(40000);
		a.setTheProf(theProfessor());
		return a;
	}

	@Bean
	public Professor theProfessor() {
		Professor p = new Professor();
		p.setName("I.M. Mean");
		p.setProfessorID(42);
		return p;
	}
}
