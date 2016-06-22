package com.springjms.listener;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.inject.Inject;
import javax.jms.*;

/**
 * Created by Administrator on 2016.4.20.
 */
public class ConsumerSessionAwareMessageListener implements SessionAwareMessageListener{
	/**
	 * Callback for processing a received JMS message.
	 * <p>Implementors are supposed to process the given Message,
	 * typically sending reply messages through the given Session.
	 * @param message
	 * 		the received JMS message (never {@code null})
	 * @param session
	 * 		the underlying JMS Session (never {@code null})
	 * @throws JMSException
	 * 		if thrown by JMS methods
	 */
	@Inject
	@Qualifier("sessionAwareQueue")
	private Destination destination;
	@Override
	public void onMessage (Message message, Session session) throws JMSException {
		System.out.println("收到一条消息");
		System.out.println("消息内容是：" + ((TextMessage)message).getText ());
		MessageProducer producer = session.createProducer(destination);
		Message textMessage = session.createTextMessage ("告诉你：我顶你个肺，我终于收到了");

		producer.send(textMessage);
	}
}
