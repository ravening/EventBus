package com.rakesh.eventbus.models;

public class IdealPayment extends PaymentItem {

    public IdealPayment(Long amount) {
        super(amount);
    }

    @Override
    public String toString() {
        return "Received Ideal card payment for amount " + super.toString();
    }
}
