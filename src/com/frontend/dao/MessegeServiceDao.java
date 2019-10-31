package com.frontend.dao;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MessegeServiceDao {
	
	static Connection connection;
	static Session session;
	static Destination queue;
	static ConnectionFactory cf;
	
	
	
	public static void init(){
		Context context;
		try {
			context = new InitialContext ();
			cf = (ConnectionFactory) 
					  context.lookup ("jms/SampleConnectionFactory");
			queue = (Destination) context.lookup ("jms/SampleQueue");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void sendTxtMessage(String mensaje) {
		try {
			connection = cf.createConnection ();
			session = connection.createSession (false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(queue);
			TextMessage txtMsg = session.createTextMessage ("Sample P2P Queue TextMessage");
			producer.send(txtMsg);
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public TextMessage recibeTxtMessage(String mensaje) {
		TextMessage message = null;
		try {
			connection = cf.createConnection ();
			session = connection.createSession (false, Session.AUTO_ACKNOWLEDGE);
			MessageConsumer consumer = session.createConsumer(queue);
			message = (TextMessage) consumer.receive();
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
		
	}

}
