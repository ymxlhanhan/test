package com.test.test_backend.common.config;

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

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 开启请求保护
        http.authorizeHttpRequests(auth ->
                        auth
                                // 不需要验证的
                                .requestMatchers("/sys/user/**").permitAll()
                                // 对所有请求开启保护
                                .anyRequest()
                                // 已认证的请求会被自动授权
                                .authenticated()
                        );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder().username("user").password(new BCryptPasswordEncoder().encode("12345")).roles("admin").build();
        return new InMemoryUserDetailsManager(user);
    }
}
