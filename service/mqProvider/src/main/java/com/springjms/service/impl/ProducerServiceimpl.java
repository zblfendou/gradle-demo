package com.springjms.service.impl;

import com.springjms.service.ProducerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.*;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.jms.*;

/**
 * Created by Administrator on 2016.4.20.
 */
@Service
public class ProducerServiceimpl implements ProducerService {
	@Inject
	private JmsTemplate jmsTemplate;
	@Inject
	@Qualifier ("responseQueue")
	private Destination responseDestination;
	@Override
	public void sendMessage (Destination destination, final String message) {
		System.out.println("---------------生产者发送消息-----------------");
		System.out.println("---------------生产者发了一个消息：" + message);
		jmsTemplate.send(destination, new MessageCreator () {
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage (message);
				//textMessage.setJMSReplyTo (responseDestination);
				return textMessage;
			}
		});
	}

}
