package com.utils;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Administrator on 2016.6.21.
 */
public class CodeUtils implements Serializable {

	private static final long serialVersionUID = - 6524950726250520593L;

	/**
	 * 生成32位随机字符串
	 * @return
	 */
	private static String generateUUID () {
		return UUID.randomUUID ().toString ();
	}

	public static void main (String[] args) {
		System.out.println (generateUUID ());
	}
}
