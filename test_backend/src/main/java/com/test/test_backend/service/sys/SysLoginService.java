package com.test.test_backend.service.sys;

import com.test.test_backend.common.utils.JsonResult;
import com.test.test_backend.dto.LoginDto;
import com.test.test_backend.dto.RegisterDto;
import com.test.test_backend.vo.LoginVo;

public interface SysLoginService {
    JsonResult<LoginVo> login(LoginDto loginDto);

    JsonResult<String> register(RegisterDto registerDto);
}
