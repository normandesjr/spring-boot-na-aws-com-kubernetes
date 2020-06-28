package com.hibicode.personalloan.service.domain;

import java.math.BigDecimal;

public class Offer {

    private BigDecimal minimumTicket;
    private BigDecimal maximumTicket;
    private BigDecimal monthlyInterestRate;
    private Integer minimumNumberOfPayments;
    private Integer maximumNumberOfPayments;
    private Integer daysToFirstPayment;

    public Offer(BigDecimal minimumTicket, BigDecimal maximumTicket, BigDecimal monthlyInterestRate,
                 Integer minimumNumberOfPayments, Integer maximumNumberOfPayments, Integer daysToFirstPayment) {
        this.minimumTicket = minimumTicket;
        this.maximumTicket = maximumTicket;
        this.monthlyInterestRate = monthlyInterestRate;
        this.minimumNumberOfPayments = minimumNumberOfPayments;
        this.maximumNumberOfPayments = maximumNumberOfPayments;
        this.daysToFirstPayment = daysToFirstPayment;
    }

    public BigDecimal getMinimumTicket() {
        return minimumTicket;
    }

    public BigDecimal getMaximumTicket() {
        return maximumTicket;
    }

    public BigDecimal getMonthlyInterestRate() {
        return monthlyInterestRate;
    }

    public Integer getMinimumNumberOfPayments() {
        return minimumNumberOfPayments;
    }

    public Integer getMaximumNumberOfPayments() {
        return maximumNumberOfPayments;
    }

    public Integer getDaysToFirstPayment() {
        return daysToFirstPayment;
    }
}
