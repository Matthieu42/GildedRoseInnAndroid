package fr.iut_valence.tinnesm.gildedroseinn;

import android.app.Application;
import fr.iut_valence.tinnesm.gildedroseinn.GildedRoseModel.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tinnesm on 31/01/18.
 */
public class GildedRoseApp extends Application {
    private ArrayList<AbstractItem> items = new ArrayList<>(Arrays.asList(new AgedBrieItem( 2, 0,20),
            new CommonItem( 5, 7,24),
            new SulfurasItem(0, 80,30),
            new SulfurasItem(-1, 80,41),
            new SulfurasItem(15, 20, 5),
            new BackStagePassItem(10, 49, 14),
            new BackStagePassItem( 5, 49, 15),
            new CommonItem(3, 6, 16)));

    public GildedRose gildedRoseInv = new GildedRose();

    public GildedRose gildedRoseShop = new GildedRose(items);

    public int money = 100;

    public GildedRoseApp getApplication(){
        return this;
    }

}
