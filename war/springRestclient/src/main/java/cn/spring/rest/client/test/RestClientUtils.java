package cn.spring.rest.client.test;

import org.apache.commons.collections.MapUtils;
import org.slf4j.*;
import org.springframework.http.HttpEntity;
import org.springframework.util.*;

import java.util.Map;

/**
 * Created by Administrator on 2016.5.30.
 */
public class RestClientUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger (RestClientUtils.class);

	/**
	 * post请求
	 * @param url
	 * @param formParams
	 * @return
	 */
	public static String doPost (String url, Map<String, Object> formParams) {
		if (MapUtils.isEmpty (formParams)) {
			return doPost (url);
		}

		try {
			MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<> ();
			formParams.keySet ().stream ().forEach (key -> requestEntity.add (key, MapUtils.getObject (formParams, key, "")));
			return RestClient.getClient ().postForObject (url, requestEntity, String.class);
		} catch (Exception e) {
			LOGGER.error ("POST请求出错：{}", url, e); return null;
		}
	}

	/**
	 * post请求
	 * @param url
	 * @return
	 */
	public static String doPost (String url) {
		try {
			return RestClient.getClient ().postForObject (url, HttpEntity.EMPTY, String.class);
		} catch (Exception e) {
			LOGGER.error ("POST请求出错：{}", url, e); return null;
		}
	}

	/**
	 * get请求
	 * @param url
	 * @return
	 */
	public static String doGet (String url) {
		try {
			return RestClient.getClient ().getForObject (url, String.class);
		} catch (Exception e) {
			LOGGER.error ("GET请求出错：{}", url, e); return null;
		}

	}
}
