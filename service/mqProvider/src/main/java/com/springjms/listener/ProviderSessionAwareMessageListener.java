package com.springjms.listener;

import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.*;

/**
 * Created by Administrator on 2016.4.20.
 */
public class ProviderSessionAwareMessageListener implements SessionAwareMessageListener {
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
	@Override
	public void onMessage (Message message, Session session) throws JMSException {
		TextMessage textMessage = (TextMessage) message;
		System.out.println ("回来了：" + textMessage.getText ());
	}
}
