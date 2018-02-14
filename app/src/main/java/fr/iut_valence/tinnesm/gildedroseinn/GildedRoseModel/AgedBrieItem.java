package fr.iut_valence.tinnesm.gildedroseinn.GildedRoseModel;

public class AgedBrieItem extends AbstractItem
{	
	public AgedBrieItem(int sellIn, int quality, int price)
	{
		super ("Aged Brie", sellIn, quality,price);
	}

	@Override
	protected void updatePrice() {
		if(isPriceInBound()){
			this.price++;
		}
	}

	public void updateQuality()
	{		
		increaseQualityWithinBounds();
		if (hasExpired())
			increaseQualityWithinBounds();
	}
}
