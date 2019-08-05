package com.rakesh.eventbus.service;

import com.google.common.eventbus.Subscribe;
import com.rakesh.eventbus.models.IdealPayment;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IdealPaymentSubscriber extends EventSubscriber<IdealPayment> {
    private static int count = 0;

    @Subscribe
    public void handleIdealPayment(IdealPayment payment) {
        log.info("Handling ideal payment: {}", payment);
        count++;
    }

    public int getCount() {
        return count;
    }
}
