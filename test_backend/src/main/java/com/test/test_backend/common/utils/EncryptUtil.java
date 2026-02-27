package com.test.test_backend.common.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncryptUtil {

    public static String getEncryptPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static boolean checkPassword(String password, String password2) {
        return new BCryptPasswordEncoder().matches(password, password2);
    }
}
