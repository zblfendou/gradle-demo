package cn.shiro.demo.repositories;

import cn.shiro.demo.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2016.4.28.
 */
public interface PermissionRepository extends JpaRepository<Permission,String> {
}
