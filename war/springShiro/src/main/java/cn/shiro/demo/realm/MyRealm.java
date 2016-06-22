package cn.shiro.demo.realm;

import cn.shiro.demo.models.*;
import cn.shiro.demo.service.UserService;
import org.apache.commons.lang.builder.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.*;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.*;

import javax.inject.Inject;
import java.util.*;

/**
 * Created by Administrator on 2016.4.21.
 */
public class MyRealm extends AuthorizingRealm {
	@Inject
	private UserService userService;

	/**
	 * 为当前登录的Subject授予角色和权限
	 * 本例中该方法的调用时机为需授权资源被访问时
	 * 并且每次访问需授权资源时都会执行该方法中的逻辑,这表明本例中默认并未启用AuthorizationCache
	 * 个人感觉若使用了Spring3.1开始提供的ConcurrentMapCache支持,则可灵活决定是否启用AuthorizationCache
	 * 比如说这里从数据库获取权限信息时,先去访问Spring3.1提供的缓存,而不使用Shior提供的AuthorizationCache
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo (PrincipalCollection principals) {
		//获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()
		String currentUsername = (String) super.getAvailablePrincipal (principals);
		List<String> roleList = new ArrayList<String> ();
		List<String> permissionList = new ArrayList<String> ();
		//从数据库中获取当前登录用户的详细信息
		User user = userService.getUserByName (currentUsername);
		//实体类User中包含有用户角色的实体类信息
		if (null != user) {
			user.getRoles ().forEach (role -> {
				roleList.add (role.getName ());//获取当前登录用户的角色
				role.getPermissions ().forEach (permission -> permissionList.add (permission.getPerm ()));//获取权限
			});
		} else {
			throw new AuthorizationException ();
		}
		//为当前用户设置角色和权限
		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo ();
		simpleAuthorInfo.addRoles (roleList);
		simpleAuthorInfo.addStringPermissions (permissionList);
		//若该方法什么都不做直接返回null的话,就会导致任何用户访问/admin/listUser.jsp时都会自动跳转到unauthorizedUrl指定的地址
		//详见applicationContext.xml中的<bean id="shiroFilter">的配置
		return simpleAuthorInfo;
	}


	/**
	 * 验证当前登录的Subject
	 * 本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()时
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo (AuthenticationToken authcToken) throws AuthenticationException {
		//获取基于用户名和密码的令牌
		//实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的
		//两个token的引用都是一样的
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		System.out.println ("验证当前Subject时获取到token为" + ReflectionToStringBuilder.toString (token, ToStringStyle.MULTI_LINE_STYLE));
		User user = userService.getUserByName (token.getUsername ());
		if (null == user) throw new UnknownAccountException ();//没找到帐号
		if (user.getLocked () == Boolean.TRUE) throw new LockedAccountException (); //帐号锁定
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo (
				user.getLoginName (), //用户名
				user.getPassword (), //密码
				new SerializableByteSource (user.getSecuritySalt ()),//salt=username+salt
				getName ()  //realm name
		);
		return authenticationInfo;
	}


	/**
	 * 将一些数据放到ShiroSession中,以便于其它地方使用
	 * 比如Controller使用时直接用HttpSession.getAttribute(key)就可以取到
	 */
	private void setSession (Object key, Object value) {
		Subject currentUser = SecurityUtils.getSubject ();
		if (null != currentUser) {
			Session session = currentUser.getSession ();
			System.out.println ("Session默认超时时间为[" + session.getTimeout () + "]毫秒");
			if (null != session) {
				session.setAttribute (key, value);
			}
		}
	}
}
