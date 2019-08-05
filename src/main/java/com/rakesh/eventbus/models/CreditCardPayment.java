package com.rakesh.eventbus.models;

public class CreditCardPayment extends PaymentItem{

    public CreditCardPayment(Long amt) {
        super(amt);
    }

    @Override
    public String toString() {
        return "Received credit card payment of amount " + super.toString();
    }
}
