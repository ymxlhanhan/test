package com.test.test_backend.common.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncryptUtil {

    private static final RSA RSA_NOW = new RSA();

    /**
     * BCrypt加密（单项加密，加入数据库的部分）
     *
     * @author: ymxl
     * @date: 2026/3/2
    */
    public static String getEncryptPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    /**
     * BCrypt加密判断（单项加密）
     *
     * @author: ymxl
     * @date: 2026/3/2
     */
    public static boolean checkPassword(String password, String password2) {
        return new BCryptPasswordEncoder().matches(password, password2);
    }

    /**
     * 公钥
     */
    public static String getPublicKey() {
        return RSA_NOW.getPublicKeyBase64();
    }

    /**
     * 公钥
     */
    public static String getPrivateKey() {
        return RSA_NOW.getPrivateKeyBase64();
    }
}
