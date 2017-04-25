package aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
	
	@Pointcut("execution(void myMethod())")
	public void myPointcut()  {}
	
	@Before("myPointcut()")
	public void doAdvice() {
		System.out.println("My advice, sir: get de-cer.");
	}

	@After("myPointcut()")
	public void doMoreAdvice() {
		System.out.println("You are welcome!");
	}

}
