package com.hibicode.personalloan.controller.validation.offer;

import com.hibicode.personalloan.controller.validation.offer.validator.ValidTicketsValuesValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = { ValidTicketsValuesValidator.class })
public @interface ValidTicketsValues {

    String message() default "maximum ticket value should be equal or greater than minimum ticket value";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
