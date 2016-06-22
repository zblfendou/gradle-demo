package cn.shiro.demo.service.impl;

import cn.shiro.demo.models.Permission;
import cn.shiro.demo.repositories.PermissionRepository;
import cn.shiro.demo.service.PermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by Administrator on 2016.4.28.
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
	@Inject
	private PermissionRepository dao;

	@Override
	@Transactional
	public void save (Permission permission) {
		dao.save (permission);
	}

	@Override
	public Permission getPermission (String token) {
		return dao.findOne (token);
	}
}
