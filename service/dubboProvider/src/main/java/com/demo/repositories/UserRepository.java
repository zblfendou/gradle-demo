package com.demo.repositories;

import com.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by love-jia on 2016/3/4.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
