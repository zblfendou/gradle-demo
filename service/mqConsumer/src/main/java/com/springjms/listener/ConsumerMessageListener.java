package com.springjms.listener;

import javax.jms.*;

/**
 * Created by Administrator on 2016.4.20.
 */
public class ConsumerMessageListener implements MessageListener {
	@Override
	public void onMessage (Message message) {
		//这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换
//		TextMessage textMessage = (TextMessage) message;
//		System.out.println ("接收到一个纯文本消息。");
//		try {
//			System.out.println ("消息内容是：" + textMessage.getText ());
//		} catch (JMSException e) {
//			e.printStackTrace ();
//		}
	}
}
