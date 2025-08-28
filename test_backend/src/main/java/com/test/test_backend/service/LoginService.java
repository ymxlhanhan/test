package com.test.test_backend.service;

import com.test.test_backend.common.utils.JsonResult;
import com.test.test_backend.dto.LoginDto;

public interface LoginService {
    JsonResult<Boolean> login(LoginDto loginDto);
}
