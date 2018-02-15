package fr.iut_valence.tinnesm.gildedroseinn;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;

import fr.iut_valence.tinnesm.gildedroseinn.GildedRoseModel.*;

/**
 * Created by tinnesm on 31/01/18.
 */
public class GildedRoseApp extends Application {
    private ArrayList<Item> items = new ArrayList<Item>(Arrays.asList(new AgedBrieItem( 2, 0,20),
            new CommonItem( 5, 7,24),
            new SulfurasItem(0, 80,30),
            new SulfurasItem(-1, 80,41),
            new SulfurasItem(15, 20, 5),
            new BackStagePassItem(10, 49, 14),
            new BackStagePassItem( 5, 49, 15),
            new CommonItem(3, 6, 16)));

    public GildedRose gildedRoseInv;

    public GildedRose gildedRoseShop = new GildedRose(items);

    public int money;

    public GildedRoseApp getApplication(){
        return this;
    }

}
