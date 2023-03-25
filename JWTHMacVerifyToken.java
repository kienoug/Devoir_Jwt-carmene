package org.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class JWTHMacVerifyToken {
    public  static void ParseValidateTocken(String secret,String tocken){
        SecretKey secretKey=new SecretKeySpec(secret.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(tocken);
        System.out.println(claimsJws.toString());
    }
    public static void main(String[] args) {
        String secret="carmene_6_kienou_ouidjia_25_2023";//256 BITS
        String jwtToken="eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiQ2FybWVuZSIsImVtYWlsIjoia2Nhcm1lbmUwN0BnbWFpbC5jb20ifQ.wp7xRxxXJZV-vND_VpWcjoGy9f89YCJ13D0Fmu7gCs8";
        ParseValidateTocken(secret,jwtToken);

    }
}


