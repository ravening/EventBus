package com.rakesh.eventbus.service;

import com.google.common.eventbus.Subscribe;
import com.rakesh.eventbus.models.DefaultPayment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DefaultPaymentSubscriber extends EventSubscriber<DefaultPayment> {
    private static int count = 0;

    @Subscribe
    public void handleDefaultPaymentMethod(DefaultPayment item) {
        log.info("Handling the default payment event {}",item);
        count++;
    }

    public int getCount() {
        return count;
    }
}
