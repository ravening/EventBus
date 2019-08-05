package com.rakesh.eventbus.service;

import com.google.common.eventbus.Subscribe;
import com.rakesh.eventbus.models.CreditCardPayment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CreditCardPaymentSubscriber extends EventSubscriber<CreditCardPayment> {
    private static int count = 0;

    @Subscribe
    public void handleCreditCardPayment(CreditCardPayment payment) {
        log.info("Handling the credit card payment event {} ",payment);
        count++;
    }

    public int getCount() {
        return count;
    }
}
