package fr.iut_valence.tinnesm.gildedroseinn;

public class Item
{
	private final String name;

	private int sellIn;

	private int quality;

	private int price;

	public Item(String name, int sellIn, int quality, int price)
	{
		this.name = name;
		this.sellIn = sellIn;
		this.price = price;
		this.quality = quality;
	}

	public String getName()
	{
		return this.name;
	}

	public void setSellIn(int sellIn)
	{
		this.sellIn = sellIn;
	}

	public int getSellIn()
	{
		return this.sellIn;
	}
	
	public int getQuality()
	{
		return quality;
	}

	public void setQuality(int quality)
	{
		this.quality = quality;
	}

	public int getPrice() {
		return price;
	}
}
