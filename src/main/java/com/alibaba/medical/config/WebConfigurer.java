package com.alibaba.medical.config;

import com.alibaba.medical.interceptor.AuthorityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebConfigurer
 * @Description TODO
 * @Author panjing
 * @Date 19-7-13 上午12:31
 * @Version 1.0
 **/
@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Autowired
    AuthorityInterceptor authorityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor(authorityInterceptor).addPathPatterns("/device/**", "/auth/**");
    }
}
