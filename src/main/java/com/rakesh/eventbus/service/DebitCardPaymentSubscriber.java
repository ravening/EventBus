package com.rakesh.eventbus.service;

import com.google.common.eventbus.Subscribe;
import com.rakesh.eventbus.models.DebitCardPayment;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DebitCardPaymentSubscriber extends EventSubscriber<DebitCardPayment> {
    private static int count = 0;

    @Subscribe
    public void handleDebitCardPayment(DebitCardPayment payment) {
        log.info("Handling debit card payment: {}", payment);
        count++;
    }

    public int getCount() {
        return count;
    }
}
