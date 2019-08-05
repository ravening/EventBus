package com.rakesh.eventbus.models;

public class DefaultPayment extends PaymentItem {

    public DefaultPayment(Long amount) {
        super(amount);
    }

    @Override
    public String toString() {
        return "Received default payment method of amount " + super.toString();
    }
}
