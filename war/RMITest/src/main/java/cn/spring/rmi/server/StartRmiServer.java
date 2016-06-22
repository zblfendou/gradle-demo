package cn.spring.rmi.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016.5.25.
 */
public class StartRmiServer {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext ("spring-rmi-server.xml");
		System.out.println("Waiting for Request from Client ...");

	}
}
