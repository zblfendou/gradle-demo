package cn.shiro.demo.service;


import cn.shiro.demo.models.Role;

/**
 * Created by Administrator on 2016.4.28.
 */
public interface RoleService {
	void save (Role role);

	Role getRole (long id);
}
