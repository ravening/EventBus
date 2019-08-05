package com.rakesh.eventbus.models;

public abstract class PaymentItem {
    private Long amount;

    public PaymentItem(Long amt) {
        this.amount = amt;
    }

    @Override
    public String toString() {
        return String.valueOf(amount);
    }
}
