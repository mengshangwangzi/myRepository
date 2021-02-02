package com.wangxu.service;

import com.wangxu.dao.UserDao;
import com.wangxu.entity.UserEntity;
import com.wangxu.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author wx
 * @Description:
 * @Title:
 * @Package
 * @date 2021/1/10 10:12
 */

@Service
@SuppressWarnings("all")
public class UserService {

    @Autowired
    private UserDao userDao;

    public String login(String username, String password) {
        UserEntity login = userDao.login(username);
        if (Objects.isNull(login)) {
            return "用户不存在";
        } else if (!login.getPassword().equals(password)) {
            return "密码错误";
        } else {
            return "登陆成功";
        }
    }

}
