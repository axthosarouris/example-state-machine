package com.github.axthosarouris;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;

public class HelloHandler implements RequestHandler<Message, Message> {

    public Message handleRequest(Message input, Context context) {
        return Message.create("hello world, I am a message", input.isLeft());
    }
}
