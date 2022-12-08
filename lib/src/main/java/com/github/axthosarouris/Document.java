package com.github.axthosarouris;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Document {

    @JsonProperty("items")
    private List<String> lines;
    @JsonProperty("left")
    private boolean left;

    public Document() {
    }

    public static Document create(List<String> text, boolean left) {
        var message = new Document();
        message.setLines(text);
        message.setLeft(left);
        return message;
    }


    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }


    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }
}
