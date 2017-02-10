package university.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import university.Student;
import university.config.AdvisorConfig;
import university.config.StudentConfig;

public class TestUniversity {
	
	public static void main(String[] args)  {
		AbstractApplicationContext ctx = 
				new AnnotationConfigApplicationContext(StudentConfig.class);
		
//		Student s = (Student)ctx.getBean(Student.class);   // get by type
		Student s = (Student)ctx.getBean("student01");
		System.out.println(s);             // runs Student.toString();
		
		ctx.close();
	}

}
