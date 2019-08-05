package com.rakesh.eventbus.models;

public class CashPayment extends PaymentItem{

    public CashPayment(Long amt) {
        super(amt);
    }

    @Override
    public String toString() {
        return "Cash payment received: amount is " + super.toString();
    }
}
