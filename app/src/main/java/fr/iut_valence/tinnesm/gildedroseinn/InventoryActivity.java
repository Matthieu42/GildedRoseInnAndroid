package fr.iut_valence.tinnesm.gildedroseinn;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class InventoryActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inventory_layout);
		final GildedRoseApp app = (GildedRoseApp) getApplication();
		final ListView itemList = (ListView) findViewById(R.id.itemList);
		final GildedRoseAdapter gildedRoseAdapter = new GildedRoseAdapter(this.getBaseContext(),
				app.gildedRoseInv.getItems(), new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				app.gildedRoseInv.getItems().remove(view.getTag());
				itemList.invalidateViews();
			}
		}, ListType.INVENTORY);
		itemList.setAdapter(gildedRoseAdapter);
	}
}
