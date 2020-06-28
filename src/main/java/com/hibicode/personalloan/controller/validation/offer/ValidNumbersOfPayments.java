package com.hibicode.personalloan.controller.validation.offer;

import com.hibicode.personalloan.controller.validation.offer.validator.ValidNumberOfPaymentsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {ValidNumberOfPaymentsValidator.class })
public @interface ValidNumbersOfPayments {

    String message() default "maximum number of payments should be equal or greater than minimum number of payments";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
