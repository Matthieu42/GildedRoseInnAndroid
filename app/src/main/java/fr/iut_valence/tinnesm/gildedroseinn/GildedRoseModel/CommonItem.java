package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

public class CommonItem extends AbstractItem
{
	public CommonItem(int sellIn, int quality)
	{
		super ("+5 Dexterity Vest", sellIn, quality);
	}

	public void updateQuality()
	{		
		decreaseQualityWithinBounds();		
		if (hasExpired())
			decreaseQualityWithinBounds();								
	}
}
