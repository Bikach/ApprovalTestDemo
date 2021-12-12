package com.approvaltest.demo;

public class Item {
    private final String name;
    protected int sellIn;
    protected int quality;

    protected Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static Item createItem(String name, int sellIn, int quality) {
        switch (name) {
            case "Aged Brie":
                return new AgedBrie(sellIn, quality);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new Backstage(sellIn, quality);
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(sellIn, quality);
            default:
             return new Item(name, sellIn, quality);
        }
    }

    protected void updateQuality() {
        if (quality > 0) quality--;
        sellIn = sellIn - 1;
        if (sellIn < 0 && quality > 0) quality--;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
