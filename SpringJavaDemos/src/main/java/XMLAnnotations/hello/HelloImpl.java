package XMLAnnotations.hello;

import org.springframework.stereotype.Component;

@Component("helloService")
public class HelloImpl implements HelloService {
	
	public void sayHello()  {
		System.out.println("Hello, from Spring");
	}
}
