package com.wangxu.config;

import com.wangxu.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wx
 * @Description: 将拦截器配置到springboot配置
 * @Title:
 * @Package
 * @date 2021/1/10 9:24
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")  //浏览器允许所有的域访问 / 注意 * 不能满足带有cookie的访问,Origin 必须是全匹配
                .allowCredentials(true)   // 允许带cookie访问
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("token")
                .maxAge(3600);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/**") // 拦截所有请求
                .excludePathPatterns("/user/login"); // 不拦截登陆接口
    }
}
