import cn.shiro.demo.models.*;
import cn.shiro.demo.service.*;
import cn.shiro.demo.service.impl.PasswordHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.*;

/**
 * Created by Administrator on 2016.4.27.
 */
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration ({"classpath:application-context.xml",
						"classpath:application-shrio.xml"})
@Rollback (false)
public class UserTest {
	@Inject
	UserService userService;
	@Inject
	RoleService roleService;
	@Inject
	PermissionService permissionService;
	@Inject
	PasswordHelper passwordHelper;

	@Test
	public void addUser () {
//		Permission permission = new Permission ();
//		permission.setName ("测试");
//		permission.setPerm ("/index/test.do");
//
//
//		Role role = new Role ();
//		role.setName ("超级管理员");
//		Set<Permission> permissions = new HashSet<> ();
//		permissions.add (permission);
//		role.setPermissions (permissions);

		User user = new User ();
		user.setLoginName ("zbl");
		user.setPassword ("1234");
		passwordHelper.encryptPassword (user);
		Set<Role> roles = new HashSet<> ();
		roles.add (roleService.getRole (1));
		user.setRoles (roles);
		userService.save (user);
	}

	@Test
	public void addRole () {
		String token = "index:test";
		Role role = new Role ();
		role.setName ("超级管理员");
		Set<Permission> permissions = new HashSet<> ();
		permissions.add (permissionService.getPermission (token));
		role.setPermissions (permissions);
		roleService.save (role);
	}

	@Test
	public void addPermission () {
		Permission permission = new Permission ();
		permission.setName ("测试");
		permission.setPerm ("index:test");
		permissionService.save (permission);
	}

	@Test
	public void login () {
		Subject subject = SecurityUtils.getSubject ();
		User user = userService.getUserByName ("zbl");
		UsernamePasswordToken token = new UsernamePasswordToken (user.getLoginName (), "1234");
		try {
			subject.login (token);
			System.out.println ("登录成功");
		} catch (AuthenticationException e) {
			e.printStackTrace ();
			System.out.println ("登录失败");
		}
	}
}
