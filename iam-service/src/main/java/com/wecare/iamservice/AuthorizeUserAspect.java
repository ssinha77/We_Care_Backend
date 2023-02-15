package com.wecare.iamservice;

import com.wecare.iamservice.exception.AuthenticationException;
import com.wecare.iamservice.util.JwtUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class AuthorizeUserAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    JwtUtil jwtUtil;

    @Around(value = "@annotation(anno)", argNames = "jp, anno") // aspect method who have the annotation @Delegate
    public Object handle(ProceedingJoinPoint joinPoint, Authorised delegate) throws Throwable {

        String token = request.getHeader("Authorization");
        String role= jwtUtil.getAllClaimsFromToken(token).get("role").asString();
        if(delegate.selfCheck()){
            String userId = jwtUtil.getAllClaimsFromToken(token).get("id").asString();
            Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
            String id  = method.getDeclaredAnnotation(PathVariable.class).value();
            if(!id.equalsIgnoreCase(userId)){
                throw new AuthenticationException("Unauthorised");
            }
        }
        if(!delegate.roles().equalsIgnoreCase(role)){
            throw new AuthenticationException("Unauthorized");
        }
//        Object obj = joinPoint.getThis(); // get the object
//        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod(); // get the origin method
//        Method target = obj.getClass().getMethod(delegate.roles(), method.getParameterTypes()); // get the delegate method
        return joinPoint.proceed(); // invoke the delegate method
    }
}
