package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import java.util.ArrayList;
import java.util.List;

public class GildedRose
{
	private List<Item> items;

	public GildedRose()
	{
		this.items = new ArrayList<Item>();
		
		//this.items.add(new Item("+5 Dexterity Vest", 10, 20));
		//this.items.add(new Item("Aged Brie", 2, 0));
		//this.items.add(new Item("Elixir of the Mongoose", 5, 7));
		//this.items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		//this.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		//this.items.add(new Item("Conjured Mana Cake", 3, 6));
	}
	
	public void addItem(Item item)
	{
		this.items.add(item);
	}
	
	public void updateItems()
	{
		for (Item item: this.items)
			item.update();
	}
}