package com.wecare.iamservice;

import org.aspectj.lang.annotation.Around;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD,ElementType.CONSTRUCTOR,ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
//@Documented
//@Constraint(validatedBy = AuthorisedValidator.class)
public @interface Authorised {

    String roles();

    boolean selfCheck() default false;
}
