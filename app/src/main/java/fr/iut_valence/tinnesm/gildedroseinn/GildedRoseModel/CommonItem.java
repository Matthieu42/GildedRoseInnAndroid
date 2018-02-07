package fr.iut_valence.tinnesm.gildedroseinn.GildedRoseModel;

public class CommonItem extends AbstractItem
{
	public CommonItem(int sellIn, int quality)
	{
		super ("+5 Dexterity Vest", sellIn, quality,42);
	}

	public void updateQuality()
	{		
		decreaseQualityWithinBounds();		
		if (hasExpired())
			decreaseQualityWithinBounds();								
	}
}
