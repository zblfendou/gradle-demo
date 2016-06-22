package cn.shiro.demo.service.impl;

import cn.shiro.demo.models.User;
import cn.shiro.demo.repositories.UserRepository;
import cn.shiro.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by Administrator on 2016.4.21.
 */
@Service ("userService")
public class UserServiceImpl implements UserService {
	@Inject
	private UserRepository userDao;

	@Override
	public User getUser (String name, String password) {
		return userDao.findOneByLoginNameAndPassword (name, password);
	}

	@Override
	public User getUserByName (String name) {
		return userDao.findOneByLoginName (name);
	}

	@Override
	@Transactional
	public void save (User user) {
		userDao.save (user);
	}
}
