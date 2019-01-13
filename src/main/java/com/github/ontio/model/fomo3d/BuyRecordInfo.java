package com.github.ontio.model.fomo3d;


public class BuyRecordInfo {
    public int txTime;
    public String txHash;
    public String buyer;
    public Double price;
    public Integer round;

    public int getTxTime() {
        return txTime;
    }

    public void setTxTime(int txTime) {
        this.txTime = txTime;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }


    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
