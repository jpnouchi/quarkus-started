package org.acme.getting.started;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * NotExpiredValidator
 */
public class NotExpiredValidator implements ConstraintValidator<NotExpired, LocalDate> {

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if(value==null) return true;
        LocalDate now = LocalDate.now();
        System.out.println("now:"+now);
        System.out.println("value:"+value);
        long time = ChronoUnit.YEARS.between(now, value);
        System.out.println("time:"+time);
        return  time > 0;
    }

    

    
}