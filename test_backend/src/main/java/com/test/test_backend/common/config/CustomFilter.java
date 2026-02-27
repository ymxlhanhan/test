package com.test.test_backend.common.config;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.test.test_backend.common.utils.TokenUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
public class CustomFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("Request URL: {}", request.getRequestURL().toString());
        // 具体过滤方法
        String token = request.getHeader("token");
//        if (StringUtils.isBlank(token)) {
//            return;
//        }

        // 过滤
        filterChain.doFilter(request, response);
    }
}
