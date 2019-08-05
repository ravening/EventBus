package com.rakesh.eventbus.service;

import com.google.common.eventbus.Subscribe;
import com.rakesh.eventbus.models.CashPayment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CashPurchaseSubscriber extends EventSubscriber<CashPayment> {
    private static int count = 0;
    @Subscribe
    public void handleCashPurchase(CashPayment payment) {
        log.info("Handling the cash payment event {} ", payment);
        count++;
    }

    public int getCount() {
        return count;
    }
}
