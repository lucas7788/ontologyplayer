package com.github.ontio.model;

import java.math.BigDecimal;

public class WinnerInfo {

    public String lastBuyer;
    public BigDecimal lastBuyerDividend;
    public String holdKeyMost;
    public BigDecimal holdKeyMostDividend;
    public String mostActive;
    public BigDecimal mostActiveDividend;
    public Integer round;


    public BigDecimal getLastBuyerDividend() {
        return lastBuyerDividend;
    }

    public void setLastBuyerDividend(BigDecimal lastBuyerDividend) {
        this.lastBuyerDividend = lastBuyerDividend;
    }

    public BigDecimal getHoldKeyMostDividend() {
        return holdKeyMostDividend;
    }

    public void setHoldKeyMostDividend(BigDecimal holdKeyMostDividend) {
        this.holdKeyMostDividend = holdKeyMostDividend;
    }

    public BigDecimal getMostActiveDividend() {
        return mostActiveDividend;
    }

    public void setMostActiveDividend(BigDecimal mostActiveDividend) {
        this.mostActiveDividend = mostActiveDividend;
    }

    public String getMostActive() {
        return mostActive;
    }

    public void setMostActive(String mostActive) {
        this.mostActive = mostActive;
    }

    public String getLastBuyer() {
        return lastBuyer;
    }

    public void setLastBuyer(String lastBuyer) {
        this.lastBuyer = lastBuyer;
    }

    public String getHoldKeyMost() {
        return holdKeyMost;
    }

    public void setHoldKeyMost(String holdKeyMost) {
        this.holdKeyMost = holdKeyMost;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }
}
