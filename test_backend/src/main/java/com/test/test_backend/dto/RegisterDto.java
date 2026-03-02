package com.test.test_backend.dto;

import lombok.Data;

@Data
public class RegisterDto {
    // 账户名
    private String account;
    // 密码
    private String password;
    // 用户名
    private String userName;
    // 备注，简介
    private String remark;
}
