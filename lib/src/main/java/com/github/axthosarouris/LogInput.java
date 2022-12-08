package com.github.axthosarouris;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LogInput extends LambdaHandler<List, List> {

    public LogInput() {
        super(List.class);
    }

    @Override
    protected List processInput(List input) throws IOException {
        var json = JSON.writeValueAsString(input);
        System.out.println(json);
        return input;
    }

}
