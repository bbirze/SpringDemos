package mypackage;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyCreationBean 
	implements BeanFactoryAware, ApplicationContextAware, InitializingBean  {
	
	private int prop1;
	private String prop2;
	
	public int getProp1() {
		return prop1;
	}
	public void setProp1(int prop1) {
		this.prop1 = prop1;
	}
	public String getProp2() {
		return prop2;
	}
	public void setProp2(String prop2) {
		this.prop2 = prop2;
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("In setBeanFactory()");
	}
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.println("In setApplicationContext()");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("In afterPropertiesSet()");
	}

	public void myInitMethod()  {
		System.out.println("In myInitMethod()");
	}
	
	@PostConstruct
	public void myPostConstructMethod() {
		System.out.println("In myPostConstructMethod()");
	}

}
