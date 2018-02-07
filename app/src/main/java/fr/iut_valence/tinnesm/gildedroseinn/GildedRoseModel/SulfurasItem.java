package fr.iut_valence.tinnesm.gildedroseinn.GildedRoseModel;

public class SulfurasItem extends AbstractItem
{	
	public SulfurasItem(int sellIn, int quality)
	{
		super ("Sulfuras, Hand of Ragnaros", sellIn, quality,50);
	}

	public void updateQuality()
	{
		decrementSellIn();
	}
}
