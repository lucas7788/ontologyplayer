package com.github.ontio.model.fomo3d;

import java.math.BigDecimal;

public class InvestRecord {
    public int txTime;
    public String banker;
    public BigDecimal amount;
    public int round;
    public String txHash;

    public int getTxTime() {
        return txTime;
    }

    public void setTxTime(int txTime) {
        this.txTime = txTime;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public String getBanker() {
        return banker;
    }

    public void setBanker(String banker) {
        this.banker = banker;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

}
