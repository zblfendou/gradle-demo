package com.utils;

import java.io.Serializable;
import java.net.*;

/**
 * Created by Administrator on 2016.6.21.
 */
public class DomainToIP implements Serializable {
	private static final long serialVersionUID = 6397198781013192326L;

	/**
	 * 根据域名获取对应ip
	 * @param domainName
	 * 		域名
	 * @return
	 * @throws UnknownHostException
	 */
	public static String getServerIP (String domainName) throws UnknownHostException {
		InetAddress server = null;
		server = InetAddress.getByName (domainName);
		return server.getHostAddress ();
	}
}
