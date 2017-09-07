package com.testask.shortenerURL.validator;

import com.testask.shortenerURL.domain.Url;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for {@link com.testask.shortenerURL.domain.Url} class,
 * implements {@link org.springframework.validation.Validator} interface.
 *
 * @author Sergey Katashevich
 * @version 1.0
 */

@Component
public class UrlValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Url.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "url", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tag.nameTag", "Required");
    }
}
