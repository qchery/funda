package com.qchery.funda.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

    private Pattern pattern = Pattern.compile("1(([38]\\d)|(5[^4&&\\d])|(4[579])|(7[0135678]))\\d{8}");

    @Override
    public void initialize(Phone phone) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value != null && pattern.matcher(value).matches();
    }
}
