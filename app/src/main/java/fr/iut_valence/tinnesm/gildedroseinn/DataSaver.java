package fr.iut_valence.tinnesm.gildedroseinn; /**
 * Created by Matthieu on 14/02/2018.
 */

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.iut_valence.tinnesm.gildedroseinn.GildedRoseModel.AbstractItem;
import fr.iut_valence.tinnesm.gildedroseinn.GildedRoseModel.GildedRose;


/**
 * Created by Matthieu on 01/02/2018.
 */

public class DataSaver {
    public static final String APP_DATA = "appData";
    public static final String MONEY = "money";
    public static final String INVENTORY = "Inventory";
    private GildedRoseApp app;
    SharedPreferences preferences;
    private SharedPreferences.Editor prefsEditor;
    private Gson gson;

    public DataSaver(GildedRoseApp app){
        this.app = app;
        preferences = app.getSharedPreferences(APP_DATA,0);
        prefsEditor = preferences.edit();
        gson = new GsonBuilder()
                .registerTypeAdapter(AbstractItem.class, new InterfaceAdapter<AbstractItem>())
                .create();
    }

    public void saveInventory(GildedRose inventory){
        String json = gson.toJson(inventory);
        prefsEditor.putString(INVENTORY, json);
        prefsEditor.apply();
    }
    public void saveMoney(int money){
        prefsEditor.putInt(MONEY, money);
        prefsEditor.apply();
    }

    public GildedRose getInventory(){
        return gson.fromJson(preferences.getString(INVENTORY,null),GildedRose.class);
    }

    public int getMoney(){
        return preferences.getInt(MONEY,0);
    }
}
