package example.testrmi.server;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceRmiImpl implements HelloService {

	@Override
	public String sayHello() {
		return "Hello world!";
	}

}
