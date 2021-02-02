package com.wangxu.dao;

import com.wangxu.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @author wx
 * @Description:
 * @Title:
 * @Package
 * @date 2021/1/10 10:13
 */
public interface UserDao extends JpaRepository<UserEntity,String>, JpaSpecificationExecutor<UserEntity> {
    @Query(value = "select u from UserEntity u where u.name = ?1")
    UserEntity login(String username);
}
