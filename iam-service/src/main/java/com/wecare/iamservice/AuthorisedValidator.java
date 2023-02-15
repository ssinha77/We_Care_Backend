package com.wecare.iamservice;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class AuthorisedValidator implements ConstraintValidator<Authorised,String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("Inside Is Valid");
        return false;
    }

//    @Override
//    public boolean isValid(String[] strings, ConstraintValidatorContext constraintValidatorContext) {
//
//    }
}
