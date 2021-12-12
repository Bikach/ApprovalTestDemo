package com.approvaltest.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApprovalTestDemoTest {

    @Test
    void shouldUpdateAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(new Item("Aged Brie", 1, 1), app.items[0]);
    }
}
