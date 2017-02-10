package university.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import university.Advisor;
import university.Student;

@Configuration
@Import(AdvisorConfig.class)
public class StudentConfig {

	@Autowired
	private Advisor a;
	
	@Bean(name="student01")
	public Student myStudent()  {
		Student s = new Student(a);
		s.setName("Harry Wolfe");
		s.setGpa(3.33);
		s.setStudentID(45);
		return s;
	}
	
//   How it's done with get by Name
//	 ----------------------------------
//	@Resource(name="myAdvisor")       // @Bean method name
//	private Advisor a;
//	
//	public Student myStudent(Advisor a)  {
//		Student s = new Student(a);
//		s.setName("Harry Wolfe");
//		s.setGpa(3.33);
//		s.setStudentID(45);
//		
//		return s;
//	}

}
