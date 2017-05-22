package BeanLifecycle.mypackage.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import BeanLifecycle.mypackage.MyDestroyBean;

public class TestDestroy {

	public static void main(String[] args) {
		AbstractApplicationContext ctx =
				new FileSystemXmlApplicationContext("src/main/java/BeanLifecycle/destroy.xml");
		
		MyDestroyBean mcb = (MyDestroyBean)ctx.getBean("myDestroyBean");
		
		ctx.close();        // must close context to invoke destroy lifecycle methods
	}

}
