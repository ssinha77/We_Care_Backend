package com.wecare.userservice.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

//    @Value("${jwt.secret}")
    private String secret;

    private Key key;

    private JWTVerifier verifier;

    @PostConstruct
    public void init(){
        this.verifier = JWT.require(Algorithm.HMAC256("secret"))
                .withIssuer("we-care-iam")
                .build();
    }


    public Map<String,Claim> getAllClaimsFromToken(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        return verifier.verify(decodedJWT).getClaims();


    }

    private boolean isTokenExpired(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);

        return decodedJWT.getExpiresAt().before(new Date());
    }

    public boolean isInvalid(String token) {
        return this.isTokenExpired(token);
    }

}