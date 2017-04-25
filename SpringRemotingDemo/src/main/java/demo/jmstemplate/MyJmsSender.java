package demo.jmstemplate;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MyJmsSender {
	
 
	private JmsTemplate template;
 
	private Destination destination;
	
	public JmsTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JmsTemplate template) {
		this.template = template;                // pass in the template
	}
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
	public void sendPurchase(final Purchase p)  {
		
		class MyMessageCreator implements MessageCreator  {
			public Message createMessage(Session session)  throws JMSException {
				ObjectMessage msg = session.createObjectMessage();
				msg.setObject(p);
				
				return msg;
			}
		}		
		MyMessageCreator mmc = new MyMessageCreator();
		template.send(destination, mmc);
	}
	

}
