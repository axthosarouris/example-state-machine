package com.github.axthosarouris;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.Collectors;

public class ReverseStringsHandler extends LambdaHandler<Batch, Batch> {


    public ReverseStringsHandler() {
        super(Batch.class);
    }

    @Override
    protected Batch processInput(Batch input) {
        var reversed = input.getItems().stream()
                .map(StringUtils::reverse)
                .collect(Collectors.toList());
        return Batch.create(reversed);
    }


}
