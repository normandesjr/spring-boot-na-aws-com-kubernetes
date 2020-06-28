package com.hibicode.personalloan.controller.validation.offer.validator;

import com.hibicode.personalloan.controller.resource.OfferRequest;
import com.hibicode.personalloan.controller.validation.offer.ValidNumbersOfPayments;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNumberOfPaymentsValidator implements ConstraintValidator<ValidNumbersOfPayments, OfferRequest> {

    @Override
    public void initialize(ValidNumbersOfPayments constraintAnnotation) {
    }

    @Override
    public boolean isValid(OfferRequest offerRequest, ConstraintValidatorContext constraintValidatorContext) {
        if (offerRequest == null || offerRequest.getMaximumNumberOfPayments() == null
                || offerRequest.getMinimumNumberOfPayments() == null) {
            return true;
        }

        return isMaximumNumberOfPaymentsValueGreaterOrEqualThanMinimumNumberOfPayments(offerRequest);
    }

    private boolean isMaximumNumberOfPaymentsValueGreaterOrEqualThanMinimumNumberOfPayments(OfferRequest offerRequest) {
        return offerRequest.getMaximumNumberOfPayments().compareTo(offerRequest.getMinimumNumberOfPayments()) >= 0;
    }
}
