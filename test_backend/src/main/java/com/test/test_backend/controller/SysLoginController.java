package com.test.test_backend.controller;

import com.test.test_backend.common.enums.CodeEnum;
import com.test.test_backend.common.utils.EncryptUtil;
import com.test.test_backend.dto.LoginDto;
import com.test.test_backend.dto.RegisterDto;
import com.test.test_backend.service.sys.SysLoginService;
import com.test.test_backend.common.utils.JsonResult;
import com.test.test_backend.vo.LoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping
public class SysLoginController {
    @Autowired
    private SysLoginService loginService;

    /**
     * 获取公钥
     *
     * @author: ymxl
     * @date: 2026/3/2
    */
    @GetMapping("/getKey")
    public JsonResult<String> getPublicKey() {
        String result = EncryptUtil.getPublicKey();
        log.info("获取公钥：{}", result);
        return JsonResult.success(result);
    }

    /**
     * 系统登录接口
     *
     * @url: /sys/login
     * @param: account, password
     * @return: JsonResult<Boolean>
     * @author: ymxl
     * @date: 2025-08-26
     */
    @PostMapping("/login")
    public JsonResult<LoginVo> login(LoginDto loginDto) {
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
     * 注册
     *
     * @author: ymxl
     * @date: 2026/3/2
    */
    @PutMapping("/register")
    public JsonResult<String> register(@RequestBody RegisterDto registerDto) {
        JsonResult<String> result;
        try {
            result = loginService.register(registerDto);
        } catch (Exception e) {
            result = JsonResult.fail("系统繁忙，请稍后在试！");
            log.error("用户注册接口异常：{}", e.getMessage());
        }
        return result;
    }

    /**
     * 检查token有效性
     *
     * @author: ymxl
     * @date: 2026/3/5
     * TODO
    */
    @GetMapping("/checkToken")
    public JsonResult<Boolean> checkToken(String account) {
        return JsonResult.success(true);
    }
}
