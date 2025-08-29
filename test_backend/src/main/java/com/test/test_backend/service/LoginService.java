package com.test.test_backend.service;

import com.test.test_backend.common.utils.JsonResult;
import com.test.test_backend.dto.LoginDto;
import com.test.test_backend.vo.LoginVo;

public interface LoginService {
    JsonResult<LoginVo> login(LoginDto loginDto);
}
