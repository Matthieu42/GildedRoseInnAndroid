package fr.iut_valence.tinnesm.gildedroseinn;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ShopActivity extends Activity
{
	private ListView itemList;
	private Item[] items;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shop_layout);
		items = new GildedRoseApp().getApplication().items;
		itemList = (ListView) findViewById(R.id.itemList);
		itemList.setAdapter(new GildedRoseAdapter(this.getBaseContext(),items));
	}
}
