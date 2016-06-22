package com.springjms.listener;

import com.springjms.model.User;
import com.springjms.repositories.UserRepository;

import javax.inject.Inject;
import java.util.Date;

/**
 * Created by Administrator on 2016.4.20.
 */
public class ConsumerListener {
	@Inject
	private UserRepository userDao;

	public void handleMessage (String message) {
		System.out.println ("ConsumerListener通过handleMessage接收到一个纯文本消息，消息内容是：" + message);
	}

	public void receiveMessage (String message) {
		System.out.println ("ConsumerListener通过receiveMessage接收到一个纯文本消息，消息内容是：" + message);
		User u = new User ();
		u.setAddress ("aaa" );
		u.setBirthday (new Date ());
		u.setName ("ffffffff" );
		userDao.save (u);
		throw new RuntimeException ("Error ,出错了");

		//return "这是ConsumerListener对象的receiveMessage方法的返回值。";
	}
}
