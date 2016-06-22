package cn.shiro.demo.service;

import cn.shiro.demo.models.User;

/**
 * Created by Administrator on 2016.4.21.
 */
public interface UserService {
	User getUser (String name, String password);

	User getUserByName (String name);

	void save (User user);

}
