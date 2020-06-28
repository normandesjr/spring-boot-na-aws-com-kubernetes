package com.hibicode.personalloan.controller.validation.offer.validator;

import com.hibicode.personalloan.controller.resource.OfferRequest;
import com.hibicode.personalloan.controller.validation.offer.ValidTicketsValues;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidTicketsValuesValidator implements ConstraintValidator<ValidTicketsValues, OfferRequest> {

    @Override
    public void initialize(ValidTicketsValues constraintAnnotation) {
    }

    @Override
    public boolean isValid(OfferRequest offerRequest, ConstraintValidatorContext constraintValidatorContext) {
        if (offerRequest == null || offerRequest.getMaximumTicket() == null || offerRequest.getMinimumTicket() == null) {
            return true;
        }

        return isMaximumTicketValueGreaterOrEqualThanMinimumTicketValue(offerRequest);
    }

    private boolean isMaximumTicketValueGreaterOrEqualThanMinimumTicketValue(OfferRequest offerRequest) {
        return offerRequest.getMaximumTicket().compareTo(offerRequest.getMinimumTicket()) >= 0;
    }
}
