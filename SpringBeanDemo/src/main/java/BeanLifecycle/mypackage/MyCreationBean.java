package BeanLifecycle.mypackage;

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
	

	public void   setProp1(int prop1)    { 
		System.out.println("\n In setProp1() given value: " + prop1 + "\n");
		this.prop1 = prop1;
	}
 
	public void   setProp2(String prop2) { 
		System.out.println("\n In setProp2() given value: " + prop2 + "\n");
		this.prop2 = prop2; 
	}

	@Override                     // BeanFactoryAware method
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("\n In BeansException.setBeanFactory() given BeanFactory: \n" + arg0 + "\n");
	}
	
	@Override                     // ApplicationContextAware method
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.println("\n In ApplicationContextAware.setApplicationContext() given ApplicationContext: \n" + arg0 + "\n");
	}
	
	@Override                     // InitializingBean method
	public void afterPropertiesSet() throws Exception {
		System.out.println("\n In InitializingBean.afterPropertiesSet()\n");
	}

	// Spring init-method configured in create.xml
	//
	public void myInitMethod()  {
		System.out.println("\n In XML Cconfigured init-method, myInitMethod()\n");
	}
	
	// @PostConstruct: JEE annotation (JSR-250)
	//                 Processed by CommonAnnotataionBeanPostProcessor
	@PostConstruct
	public void myPostConstructMethod() {
		System.out.println("\n In @PostConstruct myPostConstructMethod()\n");
	}

}
