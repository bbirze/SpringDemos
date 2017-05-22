package XMLAnnotations.hello;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new 
				FileSystemXmlApplicationContext("src/main/java/XMLAnnotations/hello.xml");
		
		Greeter greeter = (Greeter)factory.getBean("greeter");
		greeter.sendGreetings();

	}

}
