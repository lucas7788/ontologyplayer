package com.github.ontio.model;

public class WinnerInfo {

    public String lastBuyer;
    public String holdKeyMost;
    public Integer round;

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
