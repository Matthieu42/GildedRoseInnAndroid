package fr.iut_valence.tinnesm.gildedroseinn.GildedRoseModel;

public class AgedBrieItem extends AbstractItem
{	
	public AgedBrieItem(int sellIn, int quality)
	{
		super ("Aged Brie", sellIn, quality,25);
	}

	public void updateQuality()
	{		
		increaseQualityWithinBounds();
		if (hasExpired())
			increaseQualityWithinBounds();
	}
}
