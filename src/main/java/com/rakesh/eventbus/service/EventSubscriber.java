package com.rakesh.eventbus.service;

import com.google.common.eventbus.EventBus;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class EventSubscriber<T> {
    public static <E extends EventSubscriber> E factory(Class<E> clazz, EventBus eventBus) {
        E subscriber = null;

        try {
            Constructor constructor = clazz.getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            subscriber = (E) constructor.newInstance(new Object[]{});
            eventBus.register(subscriber);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return subscriber;
    }
}
