package com.neutech.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    // 使用安全的 512-bit 密钥（Base64 编码）
    private static final String SECRET_KEY_BASE64 = "4v3x7A2bZ9cY6pLqKjHnRtFwGyUiOeXmP1sD5fV8hB0tC3z6QrE9yW4oMlNvIuJk";
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(Base64.getDecoder().decode(SECRET_KEY_BASE64));

    private static final long EXPIRATION = 864_000_000; // 10天

    public static String generateToken(String idCard) {
        return Jwts.builder()
                .setSubject(idCard)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SECRET_KEY) // 直接使用 SecretKey
                .compact();
    }

    public static String parseToken(String token) {
        if (token == null || token.isEmpty()) {
            logger.warn("Token is null or empty.");
            throw new IllegalArgumentException("Token 不能为空");
        }

        try {
            return Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (JwtException e) {
            logger.error("JWT 解析失败: {}", e.getMessage(), e);
            throw new RuntimeException("无效的 Token", e);
        }
    }
}