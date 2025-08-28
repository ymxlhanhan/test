package com.test.test_backend.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5EncryptUtils {
    public static String encrypt(String password, String account) throws Exception {
        return DigestUtils.md5Hex(password);
    }
}
