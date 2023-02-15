package com.wecare.userservice.security;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class AuthorizeUserAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    JwtUtil jwtUtil;

    @Around(value = "@annotation(anno)", argNames = "jp, anno")
    public Object handle(ProceedingJoinPoint joinPoint, Authorised delegate) throws Throwable {

        String token = request.getHeader("Authorization");
        String role= jwtUtil.getAllClaimsFromToken(token).get("role").asString();
        if(delegate.selfCheck()){
            String userId = jwtUtil.getAllClaimsFromToken(token).get("id").asString();
            Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
            if(!request.getRequestURI().contains(userId)){
                throw new AuthException("Unauthorised");
            }
        }
        if(!delegate.roles().equalsIgnoreCase(role)){
            throw new AuthException("Unauthorised");
        }
//        Object obj = joinPoint.getThis(); // get the object
//        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod(); // get the origin method
//        Method target = obj.getClass().getMethod(delegate.roles(), method.getParameterTypes()); // get the delegate method
        return joinPoint.proceed(); // invoke the delegate method
    }
}
