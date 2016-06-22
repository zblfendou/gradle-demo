package cn.cookie.test;

import javax.servlet.http.Cookie;
import java.io.IOException;

/**
 * Created by Administrator on 2016.5.4.
 */
public class CookieServlet extends javax.servlet.http.HttpServlet {
	protected void doPost (javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
		String name = request.getParameter ("name");
		System.out.println (name);
		Cookie cookie = new Cookie ("test", "abc");
		cookie.setComment ("mmm");
		//cookie.setDomain (".abc.cn");
		cookie.setPath ("/");
		cookie.setMaxAge (-1);
		response.addCookie (cookie);
		response.sendRedirect ("/testCookie.jsp");
	}

	protected void doGet (javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
		doPost (request, response);
	}
}
