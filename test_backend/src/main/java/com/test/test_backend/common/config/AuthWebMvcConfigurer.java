package com.test.test_backend.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AuthWebMvcConfigurer implements WebMvcConfigurer {
//    @Autowired
//    private AuthHandlerInterceptor interceptor;
//
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry
//                // 添加拦截器
//                .addInterceptor(interceptor)
//                // 所有路径拦截
//                .addPathPatterns("/**")
//                // 不拦截的系统
//                .excludePathPatterns("/sysLogin")
////                .excludePathPatterns("/user/**")
////                .excludePathPatterns("/test")
//                .excludePathPatterns("/test/**")
//        ;
//    }
}
