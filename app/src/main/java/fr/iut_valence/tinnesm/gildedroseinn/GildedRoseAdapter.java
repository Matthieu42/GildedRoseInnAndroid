package fr.iut_valence.tinnesm.gildedroseinn;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * Created by tinnesm on 31/01/18.
 */
public class GildedRoseAdapter implements ListAdapter {

    private Item[] items;
    private Context context;

    public GildedRoseAdapter(Context context, Item[] items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return items.length;
    }


    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_layout,viewGroup, false);
        }
        Item item = (Item) this.getItem(i);
        ((TextView)view.findViewById(R.id.itemName)).setText(item.getName());
        ((TextView)view.findViewById(R.id.itemQuality)).setText(item.getQuality());
        ((TextView)view.findViewById(R.id.itemSellIn)).setText(item.getSellIn());
        return view;
    }

    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int i) {
        return false;
    }
}
