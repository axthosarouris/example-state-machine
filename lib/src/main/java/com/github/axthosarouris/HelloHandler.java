package com.github.axthosarouris;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class HelloHandler implements RequestHandler<Void, Document> {

    public Document handleRequest(Void input, Context context) {
        return randomDocument();
    }

    private Document randomDocument() {
        return Document.create(randomLines(), new Random().nextBoolean());
    }

    private List<String> randomLines() {
        return IntStream.range(0, 100).boxed()
                .map(ignored -> randomString())
                .collect(Collectors.toList());
    }

    private String randomString() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
}
