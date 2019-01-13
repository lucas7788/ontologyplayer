package com.github.ontio.model.fomo3d;

import java.math.BigDecimal;

public class WithdrawRecordInfo {

    public String address;
    public BigDecimal dividend;
    public BigDecimal inviteDividend;
    public int round;
    public int txTime;
    public String txHash;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getDividend() {
        return dividend;
    }

    public void setDividend(BigDecimal dividend) {
        this.dividend = dividend;
    }

    public BigDecimal getInviteDividend() {
        return inviteDividend;
    }

    public void setInviteDividend(BigDecimal inviteDividend) {
        this.inviteDividend = inviteDividend;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public int getTxTime() {
        return txTime;
    }

    public void setTxTime(int txTime) {
        this.txTime = txTime;
    }
}
