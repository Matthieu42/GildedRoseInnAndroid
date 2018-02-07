package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

public class AgedBrieItem extends AbstractItem
{	
	public AgedBrieItem(int sellIn, int quality)
	{
		super ("Aged Brie", sellIn, quality);
	}

	public void updateQuality()
	{		
		increaseQualityWithinBounds();
		if (hasExpired())
			increaseQualityWithinBounds();
	}
}
