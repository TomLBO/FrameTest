package com.bob.eventbusdemo.EventBus;

/**
 * Created by bob on 2016/5/11.
 */
public class ThirdEvent {
    private String message;

    public ThirdEvent(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
