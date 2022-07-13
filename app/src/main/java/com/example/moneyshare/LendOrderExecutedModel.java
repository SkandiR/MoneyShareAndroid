package com.example.moneyshare;

public class LendOrderExecutedModel {
    private int amount, RoI, credit_score;
    private String user_name;

    public LendOrderExecutedModel() {

    }
    public LendOrderExecutedModel(int amount, int roI, int credit_score, String name) {
        this.amount = amount;
        this.RoI = roI;
        this.credit_score = credit_score;
        this.user_name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getRoI() {
        return RoI;
    }

    public void setRoI(int roI) {
        RoI = roI;
    }

    public int getCredit_score() {
        return credit_score;
    }

    public void setCredit_score(int credit_score) {
        this.credit_score = credit_score;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String name) {
        this.user_name = name;
    }
}
