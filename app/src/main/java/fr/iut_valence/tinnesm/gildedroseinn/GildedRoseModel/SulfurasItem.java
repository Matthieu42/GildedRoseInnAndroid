package fr.iut_valence.tinnesm.gildedroseinn.GildedRoseModel;

public class SulfurasItem extends AbstractItem
{	
	public SulfurasItem(int sellIn, int quality, int price)
	{
		super ("Sulfuras, Hand of Ragnaros", sellIn, quality,price);
	}

	@Override
	protected void updatePrice() {

	}

	public void updateQuality()
	{
		decrementSellIn();
	}
}
