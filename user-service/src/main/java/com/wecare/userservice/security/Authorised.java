package com.wecare.userservice.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.METHOD,ElementType.CONSTRUCTOR,ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
//@Documented
//@Constraint(validatedBy = AuthorisedValidator.class)
public @interface Authorised {

    String roles();

    boolean selfCheck() default false;
}
