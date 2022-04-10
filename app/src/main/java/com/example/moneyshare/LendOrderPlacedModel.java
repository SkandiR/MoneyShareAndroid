package com.example.moneyshare;

public class LendOrderPlacedModel {
    private int amount, preferredCreditScore, offeredROI;
    public LendOrderPlacedModel() {

    }
    public LendOrderPlacedModel(int amount, int preferredCreditScore, int offeredROI) {
        this.amount = amount;
        this.preferredCreditScore = preferredCreditScore;
        this.offeredROI = offeredROI;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPreferredCreditScore() {
        return preferredCreditScore;
    }

    public void setPreferredCreditScore(int preferredCreditScore) {
        this.preferredCreditScore = preferredCreditScore;
    }

    public int getOfferedROI() {
        return offeredROI;
    }

    public void setOfferedROI(int offeredROI) {
        this.offeredROI = offeredROI;
    }
}
