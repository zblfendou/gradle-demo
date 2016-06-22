package com.demo.service;

import com.demo.models.User;
import com.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by love-jia on 2016/3/4.
 */
@Service ("userService")
public class UserServiceImpl implements UserService {
	@Inject
	private UserRepository dao;

	@Override
	@Transactional
	public void save (User user) {
		dao.save (user);
	}
}
