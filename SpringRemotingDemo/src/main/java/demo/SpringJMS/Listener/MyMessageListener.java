package demo.SpringJMS.Listener;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import example.jms.domain.Purchase;

public class MyMessageListener implements MessageListener {

	@Override
	public void onMessage(Message m) {
		System.out.println("In onMessage");
		ObjectMessage msg = (ObjectMessage)m;
		
		Purchase p;
		try {
			p = (Purchase)msg.getObject();
			PrintWriter out = new PrintWriter(
					new FileWriter("C:/temp/purchase.log"));
			
			out.println("Date  : " + p.getDate());
			out.println("Amount: " + p.getAmount());
			out.println("Reason: " + p.getReason());
			out.close();

		} catch (JMSException | IOException e) {
			e.printStackTrace();
		}
	}

}
