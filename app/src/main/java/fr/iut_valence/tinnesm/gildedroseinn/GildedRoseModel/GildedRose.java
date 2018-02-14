package fr.iut_valence.tinnesm.gildedroseinn.GildedRoseModel;

import java.util.ArrayList;

public class GildedRose
{
	private ArrayList<AbstractItem> items;
	private int day;

	public GildedRose(ArrayList<AbstractItem> inventory)
	{
		this.items = inventory;
		day = 0;
	}

	public GildedRose() {
		this.items = new ArrayList<>();
		day = 0;
	}

	public void addItem(AbstractItem item)
	{
		this.items.add(item);
	}
	
	public void updateItems()
	{
		day++;
		for (Item item: this.items)
			item.update();
	}

	public int getDay() {
		return day;
	}

	public ArrayList<AbstractItem> getItems() {
		return items;
	}
}