package com.github.axthosarouris;

import java.util.Random;

public class Message {
    private String text;
    private boolean left;

    public Message() {
    }

    public static Message create(String text, boolean left) {
        var message = new Message();
        message.setText(text);
        message.setLeft(left);
        return message;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }
}
