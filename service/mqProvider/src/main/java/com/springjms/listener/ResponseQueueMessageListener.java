package com.springjms.listener;

import javax.jms.*;

/**
 * Created by Administrator on 2016.4.20.
 */
public class ResponseQueueMessageListener implements MessageListener{
	@Override
	public void onMessage (Message message) {
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			try {
				System.out.println("接收到发送到responseQueue的一个文本消息，内容是：" + textMessage.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}
