package fr.iut_valence.tinnesm.gildedroseinn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import fr.iut_valence.tinnesm.gildedroseinn.GildedRoseModel.GildedRose;

public class HomeActivity extends Activity
{
	private TextView dayText;
	private TextView moneytext;
	private GildedRoseApp app;
	private DataSaver dataSaver;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_layout);
		app = (GildedRoseApp) getApplication();
		dayText = (TextView) findViewById(R.id.day_text);
		moneytext = (TextView) findViewById(R.id.walletTextView);
		dataSaver = new DataSaver(app);
		app.money = dataSaver.getMoney();
		if(app.money == 0){
			app.money = 100;
		}
		app.gildedRoseInv = dataSaver.getInventory();
		if(app.gildedRoseInv == null){
			app.gildedRoseInv = new GildedRose();
		}
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				nextDay();
			}
		}, 0,5000);
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
			case R.id.addMoneyButton:
				app.money+=100;
				updateWalletText();
				break;
			default :	
		}
	}

	private void nextDay()
	{
		GildedRoseApp app = (GildedRoseApp) getApplication();
		app.gildedRoseInv.updateItems();
		app.gildedRoseShop.updateItems();
		updateDayText();
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
	@Override
	protected void onStop() {
		super.onStop();
		this.dataSaver.saveInventory(app.gildedRoseInv);
		this.dataSaver.saveMoney(app.money);
	}


	private void updateWalletText(){
		moneytext.setText(String.format("%s : %d", getString(R.string.money),app.money));
	}
	private void updateDayText(){
		dayText.setText(String.format("%s : %d", getString(R.string.day),app.gildedRoseInv.getDay()));
	}

}
