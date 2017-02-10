package example.testhttpinvoker.server;

import org.springframework.stereotype.Component;

import example.testrmi.server.HelloService;

@Component
public class HelloServiceHttpInvokerImpl implements HelloService {

	@Override
	public String sayHello() {
		System.out.println("Received a request");
		return "Hello World!";
	}

}
