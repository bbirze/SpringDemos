package XMLAnnotations.hello;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("greeter")
public class Greeter {
	
	@Resource(name="helloService")
	private HelloService helloService;
	
	public void sendGreetings() {
		helloService.sayHello();
	}

}
