package com.test.test_backend.common.utils;


import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Date;

@Component
public class TokenUtil {
    private static final String PRIVATE_KEY = "aC8+44ApKL0DI2cmknHUylcx2Pfo/NKM2x73GvOenRJGgDgV/aDSBXCwHvZvmblpMJ2kx6eqmD4smUQOZJM4Dg==";
    private static final SecretKey KEY = Jwts.SIG.HS256.key().random(new SecureRandom(PRIVATE_KEY.getBytes(StandardCharsets.UTF_8))).build();
    private static final long EXPIRE_TIME = 1000 * 60 * 60 * 12; // 12个小时过期

    /**
     * 得到一个token
     *
     * @param userId
     * @param account
     * @return String
     */
    public String getToken(String userId, String account, String userRole) {
        JwtBuilder builder = Jwts.builder();
        Date now = new Date();
        builder.id(userId)
                .claim("account", account)
                .issuedAt(now)
                .expiration(new Date(now.getTime() + EXPIRE_TIME))
                .issuer(userRole)
                .signWith(KEY);
        builder.header()
                .add("type", "JWT")
                .add("alg", "HS256");
        return builder.compact();
    }

    /**
     * 解析token
     *
     * @param token
     * @return
     */
    public JsonResult<Claims> parseToken(String token) {
        JsonResult<Claims> result = new JsonResult<>();
        try {
            Jws<Claims> jws = Jwts.parser().verifyWith(KEY).build().parseSignedClaims(token);
            result.setData(jws.getPayload());
        } catch (Exception e) {
            if (e instanceof ExpiredJwtException) {
                result.setData(null);
                result.setMsg("token过期");
            }
            if (e instanceof JwtException) {
                result.setData(null);
                result.setMsg("token无效");
            }
        }
        return result;
    }
}
