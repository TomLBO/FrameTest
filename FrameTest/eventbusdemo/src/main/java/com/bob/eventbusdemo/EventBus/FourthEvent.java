package com.bob.eventbusdemo.EventBus;

/**
 * Created by bob on 2016/5/11.
 */
public class FourthEvent {
    private String message;

    public FourthEvent(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
