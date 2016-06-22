package cn.spring.rmi.server;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by Administrator on 2016.5.25.
 */
public class IHelloServiceImpl implements IHelloService {
	@Override
	public String speakHello (String msg) {
		System.out.println ("speak:" + msg);
		//TODO 发送restful请求告知客户端完成调用
		new Thread (() -> {
			try {
				Thread.sleep (5000);
				get ();
			} catch (InterruptedException e) {
				e.printStackTrace ();
			}
		}).start ();
		return "received msg";
	}

	/**
	 * 发送 get请求
	 */
	private void get () {
		CloseableHttpClient httpclient = HttpClients.createDefault ();
		try {
			// 创建
			HttpGet httpget = new HttpGet ("http://172.23.201.44:8090/rest/aa/ok");
			System.out.println ("executing request " + httpget.getURI ());
			// 执行get请求.
			CloseableHttpResponse response = httpclient.execute (httpget);
			try {
				// 获取响应实体
				HttpEntity entity = response.getEntity ();
				System.out.println ("--------------------------------------");
				// 打印响应状态
				System.out.println (response.getStatusLine ());
				if (entity != null) {
					// 打印响应内容长度
					System.out.println ("Response content length: " + entity.getContentLength ());
					// 打印响应内容
					System.out.println ("Response content: " + new String (EntityUtils.toString (entity).getBytes (), "UTF-8"));
				}
				System.out.println ("------------------------------------");
			} finally {
				response.close ();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace ();
		} catch (ParseException e) {
			e.printStackTrace ();
		} catch (IOException e) {
			e.printStackTrace ();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close ();
			} catch (IOException e) {
				e.printStackTrace ();
			}
		}
	}

}
