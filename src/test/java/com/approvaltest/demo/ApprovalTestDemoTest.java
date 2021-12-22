package com.approvaltest.demo;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import static com.approvaltest.demo.Item.createItem;

public class ApprovalTestDemoTest {

    @Test
    public void shouldVerifyAgedBrieItem(){
        var items = new Item[] {createItem("Aged Brie", 0, 0)};
        var gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        Approvals.verify(items[0].toString());
    }

    @Test
    public void shouldVerifyItems(){
        CombinationApprovals.verifyAllCombinations(
                this::doUpdateQuality,
                new String[]{"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"},
                new Integer[]{-1, 0, 2, 6, 11},
                new Integer[]{0, 1, 49, 50}
        );
    }

    private String doUpdateQuality(String name, int sellIn, int quality) {
        var items = new Item[] {createItem(name, sellIn, quality)};
        new GildedRose(items).updateQuality();
        return items[0].toString();
    }
}
