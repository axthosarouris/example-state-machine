package com.github.axthosarouris;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.commons.lang3.StringUtils;

public class ReverseStringsHandler implements RequestHandler<Message, Message> {

    @Override
    public Message handleRequest(Message input, Context context) {
        return Message.create(StringUtils.reverse(input.getText()),input.isLeft());
    }
}
