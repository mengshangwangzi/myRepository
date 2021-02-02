package com.wangxu.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangxu.utils.TokenUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wx
 * @Description: JWT拦截器
 * @Title: JWTInterceptor
 * @Package com.wangxu.interceptor
 * @date 2021/1/10 9:11
 */
// token通过http头部传递给后台
public class JWTInterceptor implements HandlerInterceptor {

    // 接口访问前验证token
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, Object> map = new HashMap<>();
        String token = request.getHeader("token");
        try {
            TokenUtils.verify(token);
            return true;
        }catch (SignatureVerificationException e){
            map.put("msg","token错误");
        }catch (TokenExpiredException e){
            map.put("msg","token过期");
        }catch (AlgorithmMismatchException e){
            map.put("msg","token算法不一致");
        }catch (Exception e){
            map.put("msg","无效签名");
        }
        map.put("state",false);
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
