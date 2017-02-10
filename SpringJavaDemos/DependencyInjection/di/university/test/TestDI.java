package di.university.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import di.university.Student;

public class TestDI {
	
	public static void main(String[] args)  {
		ApplicationContext ctx =
				new FileSystemXmlApplicationContext("DependencyInjection/spring.xml");
		
		Student s0 = (Student)ctx.getBean("student0");
		System.out.println(s0);
	
		Student s1 = (Student)ctx.getBean("student1");
		System.out.println(s1); 
		
		Student s2 = (Student)ctx.getBean("student2");
		System.out.println(s2);
		
		Student s3 = (Student)ctx.getBean("student3");
		System.out.println(s3);
		
		Student s4 = (Student)ctx.getBean("student4");
		System.out.println(s4);
		
		Student s5 = (Student)ctx.getBean("student5");
		System.out.println(s5);
		
	}

}
