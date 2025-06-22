package com.neutech.util;

import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

public class Securitykey {
    public static void main(String[] args) {
        String keyString = "123456789123456789123456789123456789123456789"; // 必须足够长（至少 64 字节）

        // 转换为 512-bit 密钥（如果字符串不够长，会抛出异常）
        SecretKey key = Keys.hmacShaKeyFor(keyString.getBytes(StandardCharsets.UTF_8));

        // 打印 Base64 编码的密钥
        String base64Key = java.util.Base64.getEncoder().encodeToString(key.getEncoded());
        System.out.println("Derived 512-bit Secret Key (Base64): " + base64Key);
    }
}