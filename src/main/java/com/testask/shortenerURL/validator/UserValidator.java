package com.testask.shortenerURL.validator;


import com.testask.shortenerURL.domain.User;
import com.testask.shortenerURL.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for {@link com.testask.shortenerURL.domain.User} class,
 * implements {@link org.springframework.validation.Validator} interface.
 *
 * @author Sergey Katashevich
 * @version 1.0
 */

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "Required");
        if (userService.getUser(user.getUserName()) != null) {
            errors.rejectValue("userName", "Duplicate.user.userName");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
    }
}
