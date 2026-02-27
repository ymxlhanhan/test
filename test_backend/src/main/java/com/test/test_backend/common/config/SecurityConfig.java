package com.test.test_backend.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity // 该注解启用web的安全功能
public class SecurityConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                // 添加拦截器
                .addInterceptor(new AuthHandlerInterceptor())
                // 所有路径拦截
                .addPathPatterns("/**")
//                .excludePathPatterns("sys/sysLogin");
        ;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 开启请求保护
        http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(
                                "/sysLogin", "/test"
                        ))
                .authorizeHttpRequests(auth ->
                        auth
                                // 不需要验证的
                                .requestMatchers(
                                        "/sysLogin"
                                        ,"/test"
//                                        ,"/test/**"
                                )
                                // 通配符**
                                .permitAll()
                                // 对所有请求开启保护
                                .anyRequest()
                                // 已认证的请求会被自动授权
                                .authenticated()
                        )
        // 自定义表单登录
//                .formLogin()
//                .loginPage("/sysLogin")
//                .usernameParameter("username")
//                .passwordParameter("password")
                // 添加过滤器
//                .addFilterAt(new CustomFilter(), UsernamePasswordAuthenticationFilter.class)
                // 登录
//                .formLogin().loginPage("/sys/login").successForwardUrl("/sys/user/list")
                    ;

        return http.build();
    }

    // 配置用户信息
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder().username("user").password(new BCryptPasswordEncoder().encode("12345")).roles("").build();
        return new InMemoryUserDetailsManager(user);
    }
}
