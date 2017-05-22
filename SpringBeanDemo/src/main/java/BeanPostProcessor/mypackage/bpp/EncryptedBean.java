package BeanPostProcessor.mypackage.bpp;

import org.springframework.stereotype.Component;

@Component("encyptedBean")
public class EncryptedBean implements Encrypted {

	private String text = "Uryyb, jbeyq";
	
	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

}
