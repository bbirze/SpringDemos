package mypackage.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String name) 
			throws BeansException {
		System.out.println("In postProcessAfterInitialization");
		
		// using Marker I/F strategy as filter,
		//   other strategy is bean naming conventions
		if (bean instanceof Encrypted)  {
			Encrypted eb = (Encrypted)bean;
			String s1 = eb.getText();
			String s2 = decrypt(s1);
			eb.setText(s2);
			System.out.println("Decrypted '" + s1 + "' to '" + s2 + "'");
		}
		return bean;         // returning given bean, not a proxy
	}


	@Override
	public Object postProcessBeforeInitialization(Object bean, String name) 
			throws BeansException {
		return bean;
	}
	

	private String decrypt(String s) {

		StringBuilder out = new StringBuilder(s.length());
		char[] ca = s.toCharArray();
		
		for(char c: ca)  {
			if (c >= 'a' && c <= 'm') 
				c+=13;
			else if (c >= 'n' && c <= 'z')
				c -=13;
			if (c >= 'A' && c <= 'M') 
				c+=13;
			else if (c >= 'N' && c <= 'Z')
				c -=13;
		
			out.append(c);
		}		
		return out.toString();
	}
	
	public static void main(String[] args) {
		MyBeanPostProcessor mbpp = new MyBeanPostProcessor();
		String s1 = mbpp.decrypt("Hello, world");
		String s2 = mbpp.decrypt(s1);
		System.out.println(s1);
		System.out.println(s2);
	}
	

}
