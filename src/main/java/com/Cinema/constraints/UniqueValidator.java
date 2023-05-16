package com.Cinema.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.Cinema.services.UsersService;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {

    @Autowired
    private UsersService usersService;

    @Override
    public void initialize(Unique unique)
    {

    }

    @Override
    public boolean isValid(Object email, ConstraintValidatorContext context)
    {
        return !usersService.findEmail((String)email);
    }
}
