package example.testhttpinvoker.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import example.testrmi.client.HelloClient;

public class ClientMainHttpInvoker {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new FileSystemXmlApplicationContext("src/main/java/httpinvokerClient.xml");
		
		System.out.println("CLIENT: About to get client from context!");
		HelloClient client = (HelloClient)ctx.getBean("helloClient");

		System.out.println(client.getHelloMsg());
		
		ctx.close();
	}

}
