package cn.shiro.demo.service;

import cn.shiro.demo.models.Permission;

/**
 * Created by Administrator on 2016.4.28.
 */
public interface PermissionService {
	void save (Permission permission);

	Permission getPermission (String token);
}
