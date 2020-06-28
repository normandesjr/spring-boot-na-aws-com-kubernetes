package com.hibicode.personalloan.repository.entity;

import com.hibicode.personalloan.service.domain.Offer;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Objects;

import static java.lang.Boolean.TRUE;

@Table(name = "offer")
@Entity
public class OfferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal minimumTicket;
    private BigDecimal maximumTicket;
    private BigDecimal monthlyInterestRate;
    private Integer minimumNumberOfPayments;
    private Integer maximumNumberOfPayments;
    private Integer daysToFirstPayment;
    private LocalDateTime dateActivated;
    private LocalDateTime dateDeactivated;
    private Boolean active;

    public OfferEntity() {
    }

    public OfferEntity(Offer offer) {
        this.minimumTicket = offer.getMinimumTicket();
        this.maximumTicket = offer.getMaximumTicket();
        this.monthlyInterestRate = offer.getMonthlyInterestRate();
        this.minimumNumberOfPayments = offer.getMinimumNumberOfPayments();
        this.maximumNumberOfPayments = offer.getMaximumNumberOfPayments();
        this.daysToFirstPayment = offer.getDaysToFirstPayment();
        this.dateActivated = LocalDateTime.now(Clock.systemUTC());
        this.active = TRUE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getDateActivated() {
        return dateActivated;
    }

    public void setDateActivated(LocalDateTime dateActivated) {
        this.dateActivated = dateActivated;
    }

    public LocalDateTime getDateDeactivated() {
        return dateDeactivated;
    }

    public void setDateDeactivated(LocalDateTime dateDeactivated) {
        this.dateDeactivated = dateDeactivated;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferEntity that = (OfferEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
