package fr.iut_valence.tinnesm.gildedroseinn;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShopActivity extends Activity
{
	private ListView itemList;
	private ArrayList<Item> items;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shop_layout);
		items = new GildedRoseApp().getApplication().items;
		itemList = (ListView) findViewById(R.id.itemList);
		View.OnClickListener onItemClick = new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast.makeText(ShopActivity.this,getString(R.string.added_item_inventory),
						Toast.LENGTH_LONG).show();
			}
		};
		itemList.setAdapter(new GildedRoseAdapter(this.getBaseContext(), items, onItemClick));
	}
}
