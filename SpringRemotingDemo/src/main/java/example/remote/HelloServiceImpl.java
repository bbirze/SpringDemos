package example.remote;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello() {
		return "Hello world!";
	}

}
