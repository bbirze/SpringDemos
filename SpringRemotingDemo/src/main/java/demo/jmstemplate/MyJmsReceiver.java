package demo.jmstemplate;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class MyJmsReceiver {
	@Autowired
	private JmsTemplate template;
	@Autowired
	private Destination destination;
	
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
	
	public Purchase receivePurchase() throws JMSException  {
		ObjectMessage msg = (ObjectMessage)template.receive(destination);
		return (Purchase)msg.getObject();
	}

}
