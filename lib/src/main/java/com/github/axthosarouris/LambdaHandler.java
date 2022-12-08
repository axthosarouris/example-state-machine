package com.github.axthosarouris;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.stream.Collectors;

public abstract class LambdaHandler<I, O> implements RequestStreamHandler {
    public static final ObjectMapper JSON = new ObjectMapper();

    private final Class<I> inputClass;

    protected LambdaHandler(Class<I> iclass) {
        this.inputClass = iclass;
    }


    @Override
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
        var json = readJsonString(input);
        var batch = JSON.readValue(json, inputClass);
        var outputBatch = processInput(batch);
        writeOutput(outputBatch, output);
    }

    protected abstract O processInput(I batch) throws JsonProcessingException, IOException;

    private static String readJsonString(InputStream input) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(input))) {
            return reader.lines().collect(Collectors.joining());
        }

    }

    private void writeOutput(O outputBatch, OutputStream output) throws IOException {
        var outputString = JSON.writeValueAsString(outputBatch);
        try (var writer = new BufferedWriter(new OutputStreamWriter(output))) {
            writer.write(outputString);
            writer.flush();
        }
    }
}
