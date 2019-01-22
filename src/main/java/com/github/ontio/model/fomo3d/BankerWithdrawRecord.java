package com.github.ontio.model.fomo3d;

import java.math.BigDecimal;

public class BankerWithdrawRecord {
    public String banker;
    public BigDecimal bankerDividend;
    public int txTime;
    public String txHash;

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

    public BigDecimal getBankerDividend() {
        return bankerDividend;
    }

    public void setBankerDividend(BigDecimal bankerDividend) {
        this.bankerDividend = bankerDividend;
    }

    public int getTxTime() {
        return txTime;
    }

    public void setTxTime(int txTime) {
        this.txTime = txTime;
    }
}
