package com.hemanth.springdemo.mvc;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {
String  courseCode;
    @Override
    public void initialize(CourseCode constraintAnnotation) {
       courseCode=constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean result = false;
        
        if(value!=null){
            if(value.startsWith(courseCode))
                result=true;
            
        }else{
            result=true;
            
        }
        return result;
    }
}
