package com.github.axthosarouris;

import java.util.Locale;
import java.util.stream.Collectors;

public class UpperCaseHandler extends LambdaHandler<Batch, Batch> {

    public UpperCaseHandler() {
        super(Batch.class);
    }

    @Override
    public Batch processInput(Batch input) {
        var upperCased = input.getItems().stream()
                .map(line -> line.toUpperCase(Locale.getDefault()))
                .collect(Collectors.toList());
        return Batch.create(upperCased);
    }

}
