package demo.jms.pojolistener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.log4j.Logger;

import demo.jmstemplate.Purchase;

public class MyMessageListener implements MessageListener {
	private Logger log = Logger.getLogger(MyMessageListener.class);
	
	public void onMessage(Message m)  {
		log.info("Got Message");
		ObjectMessage msg = (ObjectMessage)m;
		Purchase p;
		
		try {
			p = (Purchase)msg.getObject();
			log.info(p);
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
