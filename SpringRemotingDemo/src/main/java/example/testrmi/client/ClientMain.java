package example.testrmi.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ClientMain {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new FileSystemXmlApplicationContext("src/main/java/rmiClient.xml");
		
		System.out.println("CLIENT: About to get client from context!");
		HelloClient client = (HelloClient)ctx.getBean("helloClient");

		System.out.println(client.getHelloMsg());
		
		ctx.close();
	}

}
