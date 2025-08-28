package com.test.test_backend.common.config;

import com.mysql.cj.util.StringUtils;
import com.test.test_backend.common.utils.JsonResult;
import com.test.test_backend.common.utils.TokenUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class AuthHandlerInterceptor implements HandlerInterceptor {
    @Autowired
    private TokenUtil tokenUtil;

    /**
     * 拦截器
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("=====进入拦截器=====");
        if (handler instanceof HandlerMethod) {
            return Boolean.TRUE;
        }
        String token = request.getHeader("token");
        // 判断是否登录
        if (StringUtils.isNullOrEmpty(token)) {
            log.info("未登录");
            return Boolean.FALSE;
        }
        // 判断token状态
        JsonResult<Claims> result = tokenUtil.parseToken(token);
        if (result.getData() == null) {
            log.info(result.getMsg());
            return Boolean.FALSE;
        } else {
            if(result.getData().getId().equals("admin")){
                log.info("=====admin账户=====");
            }
            if(result.getData().getId().equals("user")){
                log.info("=====user账户=====");
            }
            return Boolean.TRUE;
        }
    }
}
