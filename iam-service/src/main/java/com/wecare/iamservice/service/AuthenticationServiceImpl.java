package com.wecare.iamservice.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.wecare.iamservice.client.CoachClient;
import com.wecare.iamservice.client.UserClient;
import com.wecare.iamservice.domain.Coach;
import com.wecare.iamservice.domain.User;
import com.wecare.iamservice.dto.CoachDTO;
import com.wecare.iamservice.dto.UserDTO;
import com.wecare.iamservice.repository.CoachRepository;
import com.wecare.iamservice.repository.UserRepository;
import com.wecare.iamservice.response.LoginRequest;
import com.wecare.iamservice.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private UserClient userClient;

    @Autowired
    private CoachClient coachClient;

    @Override
    public LoginResponse authenticate(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        switch (loginRequest.getLoginAs()) {
            case USER:
                Optional<UserDTO> user = userClient.validateCredentials(loginRequest).getBody();

                if (user.isPresent()) {
                    loginResponse.setIsAuthenticated(true);
                    HashMap<String,Object> claims = new HashMap<>();
                    claims.put("userId",user.get().getId());
                    claims.put("role","USER");
                    String token = JWT.create()
                            .withHeader(claims)
                            .withIssuer("we-care-iam")
                            .withIssuedAt(Date.from(Instant.now()))
                            .withExpiresAt(Date.from(Instant.now().plus(30,ChronoUnit.MINUTES)))
                            .withClaim("role","USER")
                            .withClaim("id",user.get().getId())
                            .sign(Algorithm.HMAC256("secret"))
                            ;
                     loginResponse.setAccessToken(token);
                } else {
                    loginResponse.setIsAuthenticated(false);
                }
                break;
            case COACH:
                Optional<CoachDTO> coach = coachClient.validateCoach(loginRequest);
                if (coach.isPresent()) {
                    loginResponse.setIsAuthenticated(true);
                    HashMap<String,Object> claims = new HashMap<>();
                    claims.put("userId",coach.get().getId());
                    claims.put("role","COACH");
//                    String token = Jwts.builder()
//                            .setSubject(coach.get().getId())
//                            .setClaims(claims)
//                            .setIssuedAt(Date.from(Instant.now()))
//                            .setExpiration(Date.from(Instant.now().plus(30,ChronoUnit.MINUTES)))
//                            .signWith(SignatureAlgorithm.HS256,"fdjhh3gh1238")
//                            .compact();
                    String token = JWT.create()
                            .withHeader(claims)
                            .withIssuer("we-care-iam")
                            .withIssuedAt(Date.from(Instant.now()))
                            .withExpiresAt(Date.from(Instant.now().plus(30,ChronoUnit.MINUTES)))
                            .withClaim("role","COACH")
                            .withClaim("id",coach.get().getId())
                            .sign(Algorithm.HMAC256("secret"))
                            ;
//                    String token = Jwts.builder()
//                            .setHeader(getHeaderClaims())
//                            .setSubject("we-care")
//                            .setIssuer("we-care")
//                            .setClaims(claims)
////                            .signWith(SignatureAlgorithm.ES256,"dkfjdk")
//                            .setIssuedAt(Date.from(Instant.now()))
//                            .setExpiration(Date.from(Instant.now().plus(30, ChronoUnit.MINUTES)))
//                            .compact()
//                    ;
                    loginResponse.setAccessToken(token);
                } else {
                    loginResponse.setIsAuthenticated(false);
                }
                break;
            default:
                loginResponse.setIsAuthenticated(false);
        }
        return loginResponse;
    }

    private HashMap<String, Object> getHeaderClaims() {
        HashMap<String,Object> headerClaims = new HashMap<String, Object>();
        headerClaims.put("alg", "RSA256");
        headerClaims.put("typ", "JWT");
        return headerClaims;
    }
}
