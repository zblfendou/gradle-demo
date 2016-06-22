package cn.shiro.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2016.4.21.
 */
@Controller
public class IndexController {


	@RequestMapping ("/login.do")
	public String login (@RequestParam ("name") String name,
	                     @RequestParam ("password") String password) {
		UsernamePasswordToken token = new UsernamePasswordToken (name, password,false);
		Subject subject = SecurityUtils.getSubject ();
		try {
			subject.login (token);

			System.out.println ("登录成功");
		} catch (AuthenticationException e) {
			e.printStackTrace ();
			System.out.println ("登录失败");
			return "/unauthor";
		}
		return "/success";
	}

	@RequestMapping ("/index/agf.do")
	@RequiresPermissions ("index:agf")
	public String test () {
		System.out.println ("test");
		return "/noPurview";
	}

	@RequestMapping ("/index/test.do")
	@RequiresPermissions ("index:test")
	public String aaa () {
		System.out.println ("test");
		return "/purview";
	}

	@RequestMapping ("/system/error.do")
	public String testaa () {
		System.out.println ("tes1t");
		return "/error";
	}

}
