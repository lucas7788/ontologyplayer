package com.github.ontio.model.dice;

import java.math.BigDecimal;

public class BetRecord {
    public String betTime;
    public String address;
    public int betType;
    public int betAmount;

    public void setBetTime(String betTime) {
        this.betTime = betTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBetType() {
        return betType;
    }

    public void setBetType(int betType) {
        this.betType = betType;
    }

    public int getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }
}
