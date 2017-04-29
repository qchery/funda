package com.qchery.funda.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = PhoneValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Phone {

    String message() default "手机号格式不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

