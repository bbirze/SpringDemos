package BeanPostProcessor.mypackage.bpp.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import BeanPostProcessor.mypackage.bpp.EncryptedBean;

public class TestBeanPostProcessor {

	public static void main(String[] args) {
		AbstractApplicationContext ctx =
				new FileSystemXmlApplicationContext("src/main/java/BeanPostProcessor/beanpp.xml");
		
		EncryptedBean eb = (EncryptedBean)ctx.getBean("encyptedBean");
		System.out.println("Main '" + eb.getText());
	}

}
