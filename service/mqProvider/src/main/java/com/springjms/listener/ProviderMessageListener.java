package com.springjms.listener;

import javax.jms.*;

/**
 * Created by Administrator on 2016.4.20.
 */
public class ProviderMessageListener  implements MessageListener{
	@Override
	public void onMessage (Message message) {
		TextMessage textMessage = (TextMessage)message;
		try {
			System.out.println ("来自消费者的回执消息："+textMessage.getText ());
		} catch (JMSException e) {
			e.printStackTrace ();
		}
	}
}
