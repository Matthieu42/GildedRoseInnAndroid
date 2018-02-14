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
	private TextView moneytext;
	private final static int SHOP_CODE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_layout);
		dayText = (TextView) findViewById(R.id.day_text);
		moneytext = (TextView) findViewById(R.id.walletTextView);
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
		app.gildedRoseInv.updateItems();
		app.gildedRoseShop.updateItems();
		dayText.setText(String.valueOf(app.gildedRoseInv.getDay()));
	}

	private void startInventoryActivity()
	{
		this.startActivity( new Intent(this, InventoryActivity.class));
	}

	private void startShopActivity()
	{
		Intent intent = new Intent(this, ShopActivity.class);
		this.startActivity(intent);
	}

	@Override
	protected void onResume() {
		super.onResume();
		updateWalletText();
	}

	private void updateWalletText(){
		GildedRoseApp app = (GildedRoseApp) getApplication();
		moneytext.setText(getString(R.string.money) + " " +String.valueOf(app.money));
	}

}
