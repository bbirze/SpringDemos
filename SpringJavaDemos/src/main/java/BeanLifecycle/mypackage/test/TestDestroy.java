package mypackage.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import mypackage.MyDestroyBean;

public class TestDestroy {

	public static void main(String[] args) {
		AbstractApplicationContext ctx =
				new FileSystemXmlApplicationContext("BeanLifecycle/destroy.xml");
		
		MyDestroyBean mcb = (MyDestroyBean)ctx.getBean("myDestroyBean");
		
		ctx.close();
	}

}
