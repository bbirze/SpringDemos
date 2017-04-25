package example.remote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloClient {

	@Autowired
	private HelloService helloService;
	
	public String getHelloMsg()  {
		System.out.println("CLIENT: Calling helloService.sayHello()!");
		return helloService.sayHello();
	}
}
