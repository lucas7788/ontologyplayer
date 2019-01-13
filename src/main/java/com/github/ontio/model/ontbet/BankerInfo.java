package com.github.ontio.model.ontbet;

import java.math.BigDecimal;

public class BankerInfo {
    public String funcName;
    public int blockTime;
    public String txHash;
    public String banker;
    public BigDecimal ongAmount;

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public int getBlockTime() {
        return blockTime;
    }

    public void setBlockTime(int blockTime) {
        this.blockTime = blockTime;
    }

    public String getBanker() {
        return banker;
    }

    public void setBanker(String banker) {
        this.banker = banker;
    }

    public BigDecimal getOngAmount() {
        return ongAmount;
    }

    public void setOngAmount(BigDecimal ongAmount) {
        this.ongAmount = ongAmount;
    }
}



