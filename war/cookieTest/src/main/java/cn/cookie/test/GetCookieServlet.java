package cn.cookie.test;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

/**
 * Created by Administrator on 2016.5.4.
 */
public class GetCookieServlet extends HttpServlet {
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map cookiesMap = getCookiesToMap (request);
		Object test = cookiesMap.get ("test");
		System.out.println (test);
	}

	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost (request, response);
	}

	public Map getCookiesToMap (HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object> ();
		Cookie[] cookies = request.getCookies ();
		if (cookies != null) {
			Arrays.stream (cookies).forEach (cookie -> map.put (cookie.getName (), cookie.getValue ()));
		}
		return map;
	}

	public static void main (String[] args) {
		String[] cookies={"a","b","c","d"};
		Arrays.stream (cookies);
	}
}
