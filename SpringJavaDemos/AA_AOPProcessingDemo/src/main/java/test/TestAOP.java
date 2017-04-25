package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import domain.MyDomainInterface;

public class TestAOP {

	public static void main(String[] args)  {
		String[] ctxPaths = {"Spring.xml"};
		AbstractApplicationContext ctx = 
				new ClassPathXmlApplicationContext(ctxPaths);
		
		MyDomainInterface mdi = (MyDomainInterface)ctx.getBean("myBean");
		mdi.myMethod();
		
		ctx.close();		
	}
}
