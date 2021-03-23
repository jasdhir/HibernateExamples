package com.jasdhir.hib.examples;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class TestHibernateValidator {
	public static void main(String[] args) 
    {
        //Create ValidatorFactory which returns validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
         
        //It validates bean instances
        Validator validator = factory.getValidator();
 
        User user = new User(null, "1", "abcgmail.com");
 
        //Validate bean
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
 
        //Show errors
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<User> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
        }
    }
}
