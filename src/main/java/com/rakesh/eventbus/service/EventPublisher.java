package com.rakesh.eventbus.service;

import com.google.common.eventbus.EventBus;
import com.rakesh.eventbus.models.CashPayment;
import com.rakesh.eventbus.models.CreditCardPayment;
import com.rakesh.eventbus.models.DefaultPayment;
import com.rakesh.eventbus.models.PaymentItem;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EventPublisher {
    EventBus eventBus;

    public EventPublisher(EventBus bus) {
        this.eventBus = bus;
    }

    public void createEvent(PaymentItem item) {
        eventBus.post(item);
    }
}
