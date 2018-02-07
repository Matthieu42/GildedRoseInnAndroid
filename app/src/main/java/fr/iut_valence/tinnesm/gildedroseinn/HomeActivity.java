package fr.iut_valence.tinnesm.gildedroseinn;

import android.app.Activity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends Activity
{
	private TextView dayText;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_layout);
		dayText = (TextView) findViewById(R.id.day_text);
	}

	public void homeActivityClickListener(View view)
	{
		switch (view.getId())
		{
			case R.id.shop_button : 
				startShopActivity(); 
				break;
			case R.id.inventory_button : 
				startInventoryActivity();
				break;
			case R.id.next_button :
				nextDay();
				break;
			default :	
		}
	}

	private void nextDay()
	{
		GildedRoseApp app = (GildedRoseApp) getApplication();
		app.gildedRose.updateItems();
		dayText.setText(String.valueOf(app.gildedRose.getDay()));
	}

	private void startInventoryActivity()
	{
		this.startActivity( new Intent(this, InventoryActivity.class));	
	}

	private void startShopActivity()
	{
		this.startActivity( new Intent(this, ShopActivity.class));
	}
}
