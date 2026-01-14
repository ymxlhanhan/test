package com.test.test_backend.controller;

import com.test.test_backend.common.enums.CodeEnum;
import com.test.test_backend.dto.LoginDto;
import com.test.test_backend.entity.SysUser;
import com.test.test_backend.service.LoginService;
import com.test.test_backend.common.utils.JsonResult;
import com.test.test_backend.vo.LoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/sys")
public class LoginController {
    @Autowired
    private LoginService loginService;

    /**
     * 登录接口
     *
     * @url: /sys/login
     * @param: account, password
     * @return: JsonResult<Boolean>
     * @author: ymxl
     * @date: 2025-08-26
     * TODO
     */
    @PostMapping("/login")
    public JsonResult<LoginVo> login(@RequestBody LoginDto loginDto) {
        JsonResult<LoginVo> result;
        try {
            result = loginService.login(loginDto);
        } catch (Exception e) {
            result = new JsonResult<>(null, e.getMessage(), CodeEnum.FILED.getCode(), Boolean.FALSE);
            log.error("登录接口异常：{}", e.getMessage());
        }
        return result;
    }

    /**
     * @url:
     * @param:
     * @return:
     * @author: ymxl
     * @date: 2025-08-26
     * TODO
     */
    @PutMapping
    public JsonResult<Boolean> register(SysUser sysUser) {
        JsonResult<Boolean> result = new JsonResult<>(true);
        try {

        } catch (Exception e) {
            result.setMsg(e.getMessage());
        }
        return result;
    }
}
