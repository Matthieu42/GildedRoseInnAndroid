package fr.iut_valence.tinnesm.gildedroseinn;

import android.app.Application;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tinnesm on 31/01/18.
 */
public class GildedRoseApp extends Application {
    public ArrayList<Item> items = new ArrayList<>(Arrays.asList(new Item("Aged Brie", 2, 0, 42), //
            new Item("Elixir of the Mongoose", 5, 7, 10), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80, 11), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80, 12),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20, 13),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49, 14),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49, 15),
            new Item("Conjured Mana Cake", 3, 6, 16)));

    public ArrayList<Item> inventory = new ArrayList<>();

    public GildedRoseApp getApplication(){
        return this;
    }

}
