package com.test.test_backend.common.handler;

import com.test.test_backend.common.utils.JsonResult;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;


@Slf4j
public class AuthenticationHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        JsonResult<String> result = JsonResult.fail(authException.getMessage(), "403");
        String json = result.toJsonString();
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
    }
}
