package com.wangxu.controller;

import com.wangxu.result.Result;
import com.wangxu.service.UserService;
import com.wangxu.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wx
 * @Description:
 * @Title:
 * @Package
 * @date 2021/1/10 10:23
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Map<Object, Object> login(@RequestParam String name, @RequestParam String password) {
        Map<Object, Object> map = new HashMap<>();
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("username", name);
        tokenMap.put("password", password);
        String token = TokenUtils.getToken(tokenMap);
        String message = userService.login(name, password);
        if (message.equals("用户不存在")) {
            map.put("date", new Result("201", "用户不存在", "failed"));
            return map;
        } else if (message.equals("密码错误")) {
            map.put("date", new Result("202", "密码错误", "failed"));
            return map;
        } else if (message.equals("登陆成功")) {
            map.put("token", token);
            map.put("date", new Result("200", "登陆成功", "success"));
            return map;
        } else {
            map.put("date", new Result("500", "系统内部错误请联系管理员", "failed"));
            return map;
        }
    }

    @GetMapping("/hello")
    public Result hello(@RequestParam String token) {
        TokenUtils.verify(token);
        return new Result("200", "hello！王旭", "success");
    }

}
