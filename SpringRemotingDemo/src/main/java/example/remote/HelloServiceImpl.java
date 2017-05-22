package example.remote;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello() {
		System.out.println("Server: Say'n Hello!");
		return "Hello world!";
	}

}
