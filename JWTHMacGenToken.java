package org.example;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTHMacGenToken {
    private  static  String CreateJwtToken(String secret){
        SecretKey secretKey=new SecretKeySpec(secret.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        Map<String,String> claims= new HashMap<>();
        claims.put("name","Carmene");
        claims.put("email","kcarmene07@gmail.com");
        Instant now= Instant.now();

        JwtBuilder jwtBuilder= Jwts.builder()
                .setIssuedAt(Date.from(now))
                .setId("2022032023")
                .setExpiration(Date.from(now.plus(10l, ChronoUnit.MINUTES)))
                .setSubject("JWT AUTHENTIFICATION")
                .setClaims(claims)
                .signWith(secretKey);
        String jwtTocken= jwtBuilder.compact();
        System.out.println(jwtTocken);

        return jwtTocken;
    }
    public static void main(String[] args) {
        //        Create  JWT TOCKEN
        String secret="carmene_6_kienou_ouidjia_25_2023";//256 BITS
        String jwtToken=CreateJwtToken(secret);
    }
}



