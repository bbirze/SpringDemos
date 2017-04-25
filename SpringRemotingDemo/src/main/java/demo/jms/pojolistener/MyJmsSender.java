package demo.jms.pojolistener;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import example.jms.domain.Purchase;

@Component
public class MyJmsSender {

	@Autowired
	private JmsTemplate template;
	@Autowired
	private Destination destination;
	
	public void sendPurchase(final Purchase p)  {
		
		class MyMessageCreator implements MessageCreator {
			public Message createMessage(Session session)  throws JMSException {
				ObjectMessage msg = session.createObjectMessage();
				msg.setObject(p);
				
				return msg;
			}
		}
		MyMessageCreator mmc = new MyMessageCreator();
		template.send(destination, mmc);
	}
	
	public static void main(String[] args) throws JMSException {

		AbstractApplicationContext ctx = 
				new FileSystemXmlApplicationContext("src/main/java/jmsSender.xml");
		
		System.out.println("Sender: About to get JMS sender from context!");
		MyJmsSender sender = (MyJmsSender)ctx.getBean("MyJmsSender");

		System.out.println("Sender: Sending Purchase object to Receiver!");
		sender.sendPurchase(new Purchase());
		
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
