package com.rakesh.eventbus.models;

public class DebitCardPayment extends PaymentItem {

    public DebitCardPayment(Long amount) {
        super(amount);
    }

    @Override
    public String toString() {
        return "Recived debit card payment for amount " + super.toString();
    }
}
