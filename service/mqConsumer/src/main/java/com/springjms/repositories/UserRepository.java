package com.springjms.repositories;

import com.springjms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2016.4.21.
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
