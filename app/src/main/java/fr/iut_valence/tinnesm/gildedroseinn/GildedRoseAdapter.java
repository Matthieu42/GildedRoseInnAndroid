package fr.iut_valence.tinnesm.gildedroseinn;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import fr.iut_valence.tinnesm.gildedroseinn.GildedRoseModel.AbstractItem;
import fr.iut_valence.tinnesm.gildedroseinn.GildedRoseModel.Item;

import java.util.ArrayList;

/**
 * Created by tinnesm on 31/01/18.
 */
public class GildedRoseAdapter extends BaseAdapter {

    private ArrayList<Item> items;
    private View.OnClickListener onClickListener;
    private Context context;
    private ListType type;

    public GildedRoseAdapter(Context context, ArrayList<Item> items, View.OnClickListener onClickListener, ListType type) {
        this.context = context;
        this.items = items;
        this.onClickListener = onClickListener;
        this.type = type;
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

        ((TextView)view.findViewById(R.id.itemName)).setText(item.getName());
        Resources res = context.getResources();
        switch (type){

            case INVENTORY:
                ((TextView)view.findViewById(R.id.label1)).setText(res.getString(R.string.quality) + " : " +String.valueOf(item.getQuality()));
                ((TextView)view.findViewById(R.id.label2)).setText(res.getString(R.string.sellIn) + " : " +String.valueOf(item.getSellIn()));
                break;
            case SHOP:
                ((TextView)view.findViewById(R.id.label1)).setText(res.getString(R.string.quality) + " : " +String.valueOf(item.getQuality()));
                ((TextView)view.findViewById(R.id.label2)).setText(res.getString(R.string.sellIn) + " : " +String.valueOf(item.getSellIn()));
                ((TextView)view.findViewById(R.id.label3)).setText(res.getString(R.string.price) + " : " +String.valueOf(item.getPrice()));
                break;
        }


        view.setOnClickListener(onClickListener);
        view.setTag(item);
        return view;
    }
}
