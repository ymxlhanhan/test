package com.test.test_backend.controller;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.test.test_backend.common.utils.EncryptUtil;
import com.test.test_backend.common.utils.TokenUtil;
import io.jsonwebtoken.impl.lang.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

@RestController
@RequestMapping("/test")
public class testController {

    @Autowired
    private TokenUtil tokenUtil;

    @GetMapping
    public String getToken(String userId, String account, String userRole) {
        return TokenUtil.getToken(userId, account, userRole);
    }

    public static void main(String[] args) {
        RSA rsa = new RSA(EncryptUtil.getPrivateKey(), EncryptUtil.getPublicKey());
        String a = "1234516";
        byte[] encryptBytes = rsa.encrypt(a, KeyType.PublicKey);
        String encryptStr = Base64.encode(encryptBytes);
        System.out.println("密文："+ encryptStr);
    }
}
