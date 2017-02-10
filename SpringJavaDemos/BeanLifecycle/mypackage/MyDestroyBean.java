package mypackage;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;

public class MyDestroyBean implements DisposableBean {

	@Override
	public void destroy() throws Exception {
		System.out.println("In destroy()");
	}

	public void myDestroyMethod() throws Exception {
		System.out.println("In MyDestroyMethod()");
	}

	@PreDestroy
	public void myPreDestroyMethod() throws Exception {
		System.out.println("In myPreDestroyMethod()");
	}

}
