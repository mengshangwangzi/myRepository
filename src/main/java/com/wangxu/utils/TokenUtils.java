package com.wangxu.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @author wx
 * @Description: token工具类
 * @Title: TokenUtils
 * @Package com.wangxu.utils
 * @date 2021/1/10 8:55
 */
public class TokenUtils {

    private static final String SING = "wangxu";

    public static String getToken(Map<String, String> map) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MINUTE, 30); // 设置token过期时间
        JWTCreator.Builder builder = JWT.create(); // 创建一个实例
        // 将map内容加入到token的payload负载当中
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });
        // 将过期时间和口令加入到token并生成token
        String token = builder.withExpiresAt(instance.getTime()).sign(Algorithm.HMAC256(SING));
        return token;
    }

    /**
     * @Description: 返回token内包含的信息
     *
     * @param token token
     * @return com.auth0.jwt.interfaces.DecodedJWT
     * @author 王旭
     * @date 2021/1/10 9:10
     **/
    public static DecodedJWT verify(String token) {
        return JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
    }

}
