package BeanLifecycle.mypackage.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import BeanLifecycle.mypackage.MyCreationBean;

public class TestCreation {

	public static void main(String[] args) {
		ApplicationContext ctx =
				new FileSystemXmlApplicationContext("src/main/java/BeanLifecycle/create.xml");
		
		MyCreationBean mcb = (MyCreationBean)ctx.getBean("myCreateBean");
	}

}
