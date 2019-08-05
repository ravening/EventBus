package com.rakesh.eventbus.controllers;

import com.google.common.eventbus.EventBus;
import com.rakesh.eventbus.models.CashPayment;
import com.rakesh.eventbus.models.CreditCardPayment;
import com.rakesh.eventbus.models.DebitCardPayment;
import com.rakesh.eventbus.models.DefaultPayment;
import com.rakesh.eventbus.models.IdealPayment;
import com.rakesh.eventbus.models.PaymentItem;
import com.rakesh.eventbus.service.CashPurchaseSubscriber;
import com.rakesh.eventbus.service.CreditCardPaymentSubscriber;
import com.rakesh.eventbus.service.DebitCardPaymentSubscriber;
import com.rakesh.eventbus.service.DefaultPaymentSubscriber;
import com.rakesh.eventbus.service.EventPublisher;
import com.rakesh.eventbus.service.EventSubscriber;
import com.rakesh.eventbus.service.IdealPaymentSubscriber;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HandlePaymentController {
    private EventBus eventBus;
    private EventPublisher eventPublisher;
    private CashPurchaseSubscriber cashPurchaseSubscriber;
    private CreditCardPaymentSubscriber creditCardPaymentSubscriber;
    private DefaultPaymentSubscriber defaultPaymentSubscriber;
    private DebitCardPaymentSubscriber debitCardPaymentSubscriber;
    private IdealPaymentSubscriber idealPaymentSubscriber;

    static HashMap<String, ArrayList<Class>> paymentTypeHashMap;

    // Initialize the map to contain the payment type and the corresponding subscriber
    static {
        paymentTypeHashMap = new HashMap<>();
        paymentTypeHashMap.putIfAbsent("cash", new ArrayList<>(Arrays.asList(CashPayment.class, CashPurchaseSubscriber.class)));
        paymentTypeHashMap.putIfAbsent("credit", new ArrayList<>(Arrays.asList(CreditCardPayment.class, CreditCardPaymentSubscriber.class)));
        paymentTypeHashMap.putIfAbsent("debit", new ArrayList<>(Arrays.asList(DebitCardPayment.class, DebitCardPaymentSubscriber.class)));
        paymentTypeHashMap.putIfAbsent("ideal", new ArrayList<>(Arrays.asList(IdealPayment.class, IdealPaymentSubscriber.class)));
    }

    // Iinitialize the event bus and the subscribers
    HandlePaymentController() {
        this.eventBus = new EventBus();
        eventPublisher = new EventPublisher(eventBus);
        cashPurchaseSubscriber = EventSubscriber.factory(CashPurchaseSubscriber.class, eventBus);
        creditCardPaymentSubscriber = EventSubscriber.factory(CreditCardPaymentSubscriber.class, eventBus);
        defaultPaymentSubscriber = EventSubscriber.factory(DefaultPaymentSubscriber.class, eventBus);
        debitCardPaymentSubscriber = EventSubscriber.factory(DebitCardPaymentSubscriber.class, eventBus);
        idealPaymentSubscriber = EventSubscriber.factory(IdealPaymentSubscriber.class, eventBus);
    }

    @GetMapping("/{type}")
    public ResponseEntity<?> handlePayment(@PathVariable("type") String type) {
        ArrayList<Class> classes = paymentTypeHashMap.getOrDefault(type, new ArrayList<>(Arrays.asList(DefaultPayment.class, DefaultPaymentSubscriber.class)));
        Class<?> paymentClazz = classes.get(0);
        Class<?> paymentSubscriberClazz = classes.get(1);

        int count = 0;
        Constructor<?> constructor = null;
        try {
            // create the constructor for the payment type
            constructor = paymentClazz.getConstructor(Long.class);
            PaymentItem object = (PaymentItem) constructor.newInstance(new Object[] {100L});

            // publish the event
            eventPublisher.createEvent(object);

            Thread.sleep(1000);

            // Get the count of the payment type received so far
            constructor = paymentSubscriberClazz.getConstructor(null);
            EventSubscriber eventSubscriber = (EventSubscriber) constructor.newInstance(new Object[]{});
            Method method = paymentSubscriberClazz.getDeclaredMethod("getCount", null);
            count = (int) paymentSubscriberClazz.getMethod("getCount").invoke(eventSubscriber);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new ResponseEntity("Number of " + type + " payments recived: " + count, HttpStatus.OK);
    }
}
