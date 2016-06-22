package cn.shiro.demo.service.impl;

import cn.shiro.demo.models.Role;
import cn.shiro.demo.repositories.RoleRepository;
import cn.shiro.demo.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by Administrator on 2016.4.28.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Inject
	private RoleRepository dao;

	@Override
	@Transactional
	public void save (Role role) {
		dao.save (role);
	}

	@Override
	public Role getRole (long id) {
		return dao.findOne (id);
	}
}
