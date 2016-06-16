package com.bob.eventbusdemo.EventBus;

/**
 * Created by bob on 2016/5/10.
 */
public class MessageEvent {

    public final String message;

    public MessageEvent(String message) {
        this.message = message;
    }
}
