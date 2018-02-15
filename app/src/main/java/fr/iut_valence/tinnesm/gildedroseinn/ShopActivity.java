package fr.iut_valence.tinnesm.gildedroseinn;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import fr.iut_valence.tinnesm.gildedroseinn.GildedRoseModel.AbstractItem;
import fr.iut_valence.tinnesm.gildedroseinn.GildedRoseModel.GildedRose;
import fr.iut_valence.tinnesm.gildedroseinn.GildedRoseModel.Item;

import java.util.ArrayList;

public class ShopActivity extends Activity
{
	private ListView itemList;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shop_layout);
		final GildedRoseApp app = (GildedRoseApp) getApplication();
		itemList = (ListView) findViewById(R.id.itemList);
		View.OnClickListener onItemClick = new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				AbstractItem item = (AbstractItem) view.getTag();
				if (item.getPrice() > app.money) {
					Toast.makeText(ShopActivity.this, ShopActivity.this.getString(R.string.notEnoughMoney),
							Toast.LENGTH_LONG).show();
				} else {
					app.money -= item.getPrice();
					app.gildedRoseInv.getItems().add(item);
					Toast.makeText(ShopActivity.this, ShopActivity.this.getString(R.string.added_item_inventory),
							Toast.LENGTH_LONG).show();
				}
			}
		};
		itemList.setAdapter(new GildedRoseAdapter(this.getBaseContext(),app.gildedRoseShop.getItems() , onItemClick,ListType.SHOP));
	}
}
