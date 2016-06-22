package cn.shiro.demo.repositories;

import cn.shiro.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2016.4.21.
 */
public interface UserRepository extends JpaRepository<User,Long> {
	User findOneByLoginNameAndPassword (String name, String password);

	User findOneByLoginName (String name);
}
