package fr.iut_valence.tinnesm.gildedroseinn.GildedRoseModel;

public class CommonItem extends AbstractItem
{
	public CommonItem(int sellIn, int quality, int price)
	{
		super ("+5 Dexterity Vest", sellIn, quality,price);
	}

	@Override
	protected void updatePrice() {
		if(isPriceInBound())
			price--;
	}

	public void updateQuality()
	{		
		decreaseQualityWithinBounds();		
		if (hasExpired())
			decreaseQualityWithinBounds();								
	}
}
