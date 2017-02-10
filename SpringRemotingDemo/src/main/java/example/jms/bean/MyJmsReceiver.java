package example.jms.bean;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import example.jms.domain.Purchase;
import example.testrmi.client.HelloClient;

@Component
public class MyJmsReceiver {

	@Autowired
	private JmsTemplate template;
	@Autowired
	private Destination destination;

	public Purchase receivePurchase() throws JMSException {

		ObjectMessage msg = (ObjectMessage)template.receive(destination);
		return (Purchase)msg.getObject();
	}
	
	public static void main(String[] args) throws JMSException {
		AbstractApplicationContext ctx = 
				new FileSystemXmlApplicationContext("src/main/java/jmsSpring.xml");
		
		System.out.println("Receiver: About to get jms Receiver from context!");
		MyJmsReceiver recv = (MyJmsReceiver)ctx.getBean("jmsReceiver");
		System.out.println(recv.receivePurchase());
		
		ctx.close();
	}

	public JmsTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JmsTemplate template) {
		this.template = template;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "MyJmsSender [template=" + template + ", destination=" + destination + "]";
	}
}
