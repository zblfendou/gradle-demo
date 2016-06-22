package cn.spring.rmi.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2016.5.25.
 */
public class HelloClient {
	public static void main(String[] args) throws RemoteException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext (
				"spring-rmi-client.xml");
		IHelloService hs = (IHelloService) ctx.getBean("helloService");
		System.out.println(hs.speakHello ("hello everybody,中文"));
	}
}
