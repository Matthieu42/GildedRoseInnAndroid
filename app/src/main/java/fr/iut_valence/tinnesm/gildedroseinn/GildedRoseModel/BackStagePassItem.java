package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

public class BackStagePassItem extends AbstractItem
{
	private static final int BACK_STAGE_PASS_FIRST_THRESHOLD = 10;
	private static final int BACK_STAGE_PASS_SECOND_THRESHOLD = 5;
	
	public BackStagePassItem(int sellIn, int quality)
	{
		super ("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
	}

	public void updateQuality()
	{		
		increaseQualityWithinBounds();
		if (getSellIn() < BackStagePassItem.BACK_STAGE_PASS_FIRST_THRESHOLD)				
			increaseQualityWithinBounds();
		if (getSellIn() < BackStagePassItem.BACK_STAGE_PASS_SECOND_THRESHOLD)
			increaseQualityWithinBounds();
		if (hasExpired())
			setQuality(Item.MIN_QUALITY);
	}
}
