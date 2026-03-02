package com.test.test_backend.common.utils;

import java.util.regex.Pattern;

public class PrecompiledPattern {
    // 手机号
    public static final Pattern PHONE_PATTERN = Pattern.compile("^1\\d{10}$");
    // 邮箱
    public static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,}$");
    // 密码格式
    public static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*A-Z)(?=.*a-z)(?=.*/d){8,}$");
}
