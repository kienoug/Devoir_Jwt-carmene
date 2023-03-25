package org.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.PrimitiveIterator;

public class JWTRSAVerifyToken {
    public static Jws<Claims> validateParseToken(String token) throws Exception {
        PublicKey publicKey= CryptoUtils.getPublicKeyFromCertificate("certificate.cert");
        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(publicKey)
                .build().parseClaimsJws(token);
                return claimsJws;
    }
    public static void main(String[] args) throws Exception {
        PrivateKey privateKey = CryptoUtils.getPrivateKeyFromKeyStore("mundiapolis.jks","123321","mundiapolis");
        String token="eyJhbGciOiJSUzI1NiJ9.eyJuYW1lIjoiQ2FybWVuZSIsImFnZSI6IjIyIiwiZW1haWwiOiJrYWNybWVuZTA3QGdtYWlsLmNvbSJ9.F0pRSg5VqAQNis2-4BWYDzZaivTV38vkU7EKR110nR23elyMAHB44KuS0XYXL-2kkjwOlEJiYBF7q_07_le1xc5NQk5d0x5FjnLeC1xAoe-KTIpDtOIgMnV7rrYH4D8LiGmuKaECg8BgXtkout7RP2-JapcDL_6tAoBtFOsxlqWH4rzbolsNvznZNn7-3UTi50l3I8MBizAq9bD4pUbIJv4SEcV_UKZKErb3FhGHZaO_Lw5YFyuwZL0YqKV0EIleeBEBaKKVVVE-LVPfo3MQAryCOrBd10ei1a8CDJ06xt_quoEIPsvXor93zRK0MgLaXz78kFe8psxynZH88eBMwA";
        Jws<Claims> claimsJws=validateParseToken(token);
        System.out.println("--------------------Affichade du  Header--------------------");
        System.out.println(claimsJws.getHeader());

        System.out.println("--------------------Affichage du Playload--------------------");
        System.out.println(claimsJws.getBody());

        System.out.println("--------------------Affichage de la Signature--------------------");
        System.out.println(claimsJws.getSignature());
    }
}
