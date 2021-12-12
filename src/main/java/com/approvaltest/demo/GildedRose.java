package com.approvaltest.demo;

import static java.util.Arrays.stream;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        stream(items).forEach(Item::updateQuality);
    }
}
