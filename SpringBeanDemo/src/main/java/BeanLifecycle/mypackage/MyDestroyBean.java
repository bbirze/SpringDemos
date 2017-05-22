package BeanLifecycle.mypackage;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;

public class MyDestroyBean implements DisposableBean {

	@Override                    // DisposableBean method
	public void destroy() throws Exception {
		System.out.println("\n In DisposableBean.destroy() \n");
	}

	// Spring destroy-method configured in destroy.xml
	//
	public void myDestroyMethod() throws Exception {
		System.out.println("\n In XML Configured destroy-method, MyDestroyMethod() \n");
	}

	// @@PreDestroy: JEE annotation  (JSR-250)
	//                 Processed by CommonAnnotataionBeanPostProcessor
	@PreDestroy
	public void myPreDestroyMethod() throws Exception {
		System.out.println("\n In @PreDestroy myPreDestroyMethod() \n");
	}

}
