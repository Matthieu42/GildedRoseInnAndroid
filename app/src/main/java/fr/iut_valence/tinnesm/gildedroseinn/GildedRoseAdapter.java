package fr.iut_valence.tinnesm.gildedroseinn;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tinnesm on 31/01/18.
 */
public class GildedRoseAdapter extends BaseAdapter {

    private ArrayList<Item> items;
    private Context context;

    public GildedRoseAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }


    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_layout,viewGroup, false);
        }
        Item item = (Item) this.getItem(i);
        Resources res = context.getResources();
        ((TextView)view.findViewById(R.id.itemName)).setText(item.getName());
        ((TextView)view.findViewById(R.id.itemQuality)).setText(res.getString(R.string.quality) + " : " +String.valueOf(item.getQuality()));
        ((TextView)view.findViewById(R.id.itemSellIn)).setText(res.getString(R.string.sellIn) + " : " +String.valueOf(item.getSellIn()));
        return view;
    }
}
