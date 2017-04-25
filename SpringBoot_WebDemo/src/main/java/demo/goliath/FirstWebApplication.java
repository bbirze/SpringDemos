package demo.goliath;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication = 
//    @Configuration, @EnableAutoConfiguration and @ComponentScan 

@SpringBootApplication
public class FirstWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstWebApplication.class, args);
	}
}
