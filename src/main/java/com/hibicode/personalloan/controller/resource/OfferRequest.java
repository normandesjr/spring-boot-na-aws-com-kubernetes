package com.hibicode.personalloan.controller.resource;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

public class OfferRequest {

    @DecimalMin("0.01")
    private BigDecimal minimumTicket;

    @DecimalMin("0.01")
    private BigDecimal maximumTicket;

    @DecimalMin("0.0")
    private BigDecimal monthlyInterestRate;

    @Min(1)
    private Integer minimumNumberOfPayments;

    @Min(1)
    private Integer maximumNumberOfPayments;

    @Min(1)
    private Integer daysToFirstPayment;

    public BigDecimal getMinimumTicket() {
        return minimumTicket;
    }

    public void setMinimumTicket(BigDecimal minimumTicket) {
        this.minimumTicket = minimumTicket;
    }

    public BigDecimal getMaximumTicket() {
        return maximumTicket;
    }

    public void setMaximumTicket(BigDecimal maximumTicket) {
        this.maximumTicket = maximumTicket;
    }

    public BigDecimal getMonthlyInterestRate() {
        return monthlyInterestRate;
    }

    public void setMonthlyInterestRate(BigDecimal monthlyInterestRate) {
        this.monthlyInterestRate = monthlyInterestRate;
    }

    public Integer getMinimumNumberOfPayments() {
        return minimumNumberOfPayments;
    }

    public void setMinimumNumberOfPayments(Integer minimumNumberOfPayments) {
        this.minimumNumberOfPayments = minimumNumberOfPayments;
    }

    public Integer getMaximumNumberOfPayments() {
        return maximumNumberOfPayments;
    }

    public void setMaximumNumberOfPayments(Integer maximumNumberOfPayments) {
        this.maximumNumberOfPayments = maximumNumberOfPayments;
    }

    public Integer getDaysToFirstPayment() {
        return daysToFirstPayment;
    }

    public void setDaysToFirstPayment(Integer daysToFirstPayment) {
        this.daysToFirstPayment = daysToFirstPayment;
    }

    @Override
    public String toString() {
        return "OfferRequest{" +
                "minimumTicket=" + minimumTicket +
                ", maximumTicket=" + maximumTicket +
                ", monthlyInterestRate=" + monthlyInterestRate +
                ", minimumNumberOfPayments=" + minimumNumberOfPayments +
                ", maximumNumberOfPayments=" + maximumNumberOfPayments +
                ", daysToFirstPayment=" + daysToFirstPayment +
                '}';
    }
}
