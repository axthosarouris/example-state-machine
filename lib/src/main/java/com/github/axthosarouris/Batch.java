package com.github.axthosarouris;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Batch {

    @JsonProperty("Items")
    @JsonAlias("items")
    private List<String> items;

    public Batch() {

    }

    public static Batch create(List<String> reversed) {
        var batch = new Batch();
        batch.setItems(reversed);
        return batch;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}
