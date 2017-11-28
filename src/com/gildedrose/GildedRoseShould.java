package com.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GildedRoseShould {

    @Test(expected = NullPointerException.class)
    public void
    not_accept_invalid_list_of_items() {
        GildedRose gildedRose = new GildedRose(null);

        gildedRose.updateQuality();
    }

    @Test
    public void
    accept_an_empty_list_of_items() {
        Item[] emptyItems = new Item[]{};
        GildedRose gildedRose = new GildedRose(emptyItems);

        gildedRose.updateQuality();
    }

    @Test(expected = NullPointerException.class)
    public void
    not_accept_list_with_undefined_item(){
        Item[] emptyItems = new Item[]{null};
        GildedRose gildedRose = new GildedRose(emptyItems);

        gildedRose.updateQuality();
    }

    @Test(expected = NullPointerException.class)
    public void
    not_accept_unnamed_items(){
        Item item = new Item(null, 0,0);
        Item[] items = new Item[]{item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();
    }

    @Test
    public void
    not_change_item_name_when_the_name_is_empty(){
        Item item = new Item("", 0,0);
        Item[] items = new Item[]{item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals("", gildedRose.items[0].name);
    }

    @Test
    public void
    not_change_item_name(){
        Item item = new Item("Bob", 0,0);
        Item[] items = new Item[]{item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals("Bob", gildedRose.items[0].name);
    }

    @Test
    public void
    not_change_quality_when_quality_is_zero(){
        Item item = new Item("Bob", 0,0);
        Item[] items = new Item[]{item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    public void
    decrease_quality_to_zero_when_quality_is_one(){
        Item item = new Item("Bob", 0,1);
        Item[] items = new Item[]{item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    public void
    decrease_quality_by_2_when_quality_is_over_1(){
        Item item = new Item("Bob", 0,2);
        Item[] items = new Item[]{item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(0, gildedRose.items[0].quality);
    }


    @Test
    public void
    decrease_sellin_by_one_when_sellin_is_zero(){
        Item item = new Item("Bob", 0,0);
        Item[] items = new Item[]{item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(-1, gildedRose.items[0].sellIn);
    }

    @Test
    public void
    not_change_sellin_for_Sulfuras_Hand_of_Ragnaros(){
        Item item = new Item("Sulfuras, Hand of Ragnaros", 2,0);
        Item[] items = new Item[]{item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(2, gildedRose.items[0].sellIn);
    }

    @Test
    public void
    not_change_quality_for_Sulfuras_Hand_of_Ragnaros(){
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0,54);
        Item[] items = new Item[]{item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(54, gildedRose.items[0].quality);
    }

    @Test
    public void
    increase_quality_of_aged_brie_by_2_when_below_50(){
        Item item = new Item("Aged Brie", 0,-1);
        Item[] items = new Item[]{item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(1, gildedRose.items[0].quality);
    }

    @Test
    public void
    not_change_quality_of_aged_brie_when_above_50(){
        Item item = new Item("Aged Brie", 0,50);
        Item[] items = new Item[]{item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(50, gildedRose.items[0].quality);
    }
}