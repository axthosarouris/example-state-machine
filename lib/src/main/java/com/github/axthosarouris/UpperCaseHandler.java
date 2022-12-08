package com.github.axthosarouris;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Locale;

public class UpperCaseHandler implements RequestHandler<Message, Message> {

    @Override
    public Message handleRequest(Message input, Context context) {
        return Message.create(input.getText().toUpperCase(Locale.getDefault()),input.isLeft());
    }
}
