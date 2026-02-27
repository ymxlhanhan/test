package com.test.test_backend.controller;

import com.test.test_backend.common.utils.EncryptUtil;
import com.test.test_backend.common.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        String pwd1 = EncryptUtil.getEncryptPassword("123456");
        System.out.println(pwd1);
        String pwd2 = "123456";
        System.out.println(pwd2);
        Boolean result = EncryptUtil.checkPassword(pwd2, pwd1);
        System.out.println(result);
    }
}
