package org.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

import java.security.PrivateKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTRSAGenToken {
    public static String createJwtToken(PrivateKey privateKey) {
        String token = null;
        Instant now = Instant.now();
        Map<String, String> claims = new HashMap<>();
        claims.put("name", "Carmene");
        claims.put("age", "22");
        claims.put("email", "kacrmene07@gmail.com");

        JwtBuilder jwtBuilder = Jwts.builder()
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(2, ChronoUnit.DAYS)))
                .setClaims(claims)
                .signWith(privateKey);
        token = jwtBuilder.compact();
        return token;
    }
    public static void main(String[] args) throws Exception {
        PrivateKey privateKey = CryptoUtils.getPrivateKeyFromKeyStore("mundiapolis.jks","123321","mundiapolis");
        String token = createJwtToken(privateKey);
        System.out.println(token);
    }
}
