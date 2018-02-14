package fr.iut_valence.tinnesm.gildedroseinn.GildedRoseModel;

public class BackStagePassItem extends AbstractItem
{
	private static final int BACK_STAGE_PASS_FIRST_THRESHOLD = 10;
	private static final int BACK_STAGE_PASS_SECOND_THRESHOLD = 5;
	
	public BackStagePassItem(int sellIn, int quality,int price)
	{
		super ("Backstage passes to a TAFKAL80ETC concert", sellIn, quality,price);
	}

	@Override
	protected void updatePrice() {
		if (getSellIn() < BackStagePassItem.BACK_STAGE_PASS_FIRST_THRESHOLD)
			price++;
		if (getSellIn() < BackStagePassItem.BACK_STAGE_PASS_SECOND_THRESHOLD)
			price++;
		if (hasExpired())
			price--;
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
