package fr.iut_valence.tinnesm.gildedroseinn.GildedRoseModel;

public abstract class AbstractItem implements Item
{
	protected final static int MIN_QUALITY = 0;
	private final static int MAX_QUALITY = 50;
	protected final static int MIN_PRICE = 1;
	protected final static int MAX_PRICE = 100;
	private String name;
	private int sellIn;
	private int quality;
	protected int price;

	public AbstractItem(){

	}
	public AbstractItem(String name, int sellIn, int quality, int price)
	{
		this.price = price;
		this.setName(name);
		this.setSellIn(sellIn);
		this.setQuality(quality);
	}

	/* (non-Javadoc)
	 * @see fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring.Item#getName()
	 */
	@Override
	public final String getName()
	{
		return this.name;
	}

	/* (non-Javadoc)
	 * @see fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring.Item#setName(java.lang.String)
	 */
	@Override
	public final void setName(String name)
	{
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring.Item#getSellIn()
	 */
	@Override
	public final int getSellIn()
	{
		return this.sellIn;
	}

	/* (non-Javadoc)
	 * @see fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring.Item#setSellIn(int)
	 */
	@Override
	public final void setSellIn(int sellIn)
	{
		this.sellIn = sellIn;
	}

	/* (non-Javadoc)
	 * @see fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring.Item#getQuality()
	 */
	@Override
	public final int getQuality()
	{
		return this.quality;
	}

	/* (non-Javadoc)
	 * @see fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring.Item#setQuality(int)
	 */
	@Override
	public final void setQuality(int quality)
	{
		this.quality = quality;
	}

	/* (non-Javadoc)
	 * @see fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring.Item#update()
	 */
	@Override
	public final void update()
	{
		updateSellIn();		
		updateQuality();
		updatePrice();
	}

	protected abstract void updatePrice();

	public void updateSellIn()
	{

	}

	public final void decrementSellIn()
	{
		setSellIn(getSellIn() - 1);
	}
	
	public abstract void updateQuality();
	
	public final void increaseQualityWithinBounds()
	{
		if (getQuality() < MAX_QUALITY)
			incrementQuality();
	}

	public final void decreaseQualityWithinBounds()
	{
		if (getQuality() > MIN_QUALITY)
				decrementQuality();
	}

	public final void decrementQuality()
	{
		setQuality(getQuality() - 1);
	}

	public final void incrementQuality()
	{
		setQuality(getQuality() + 1);
	}

	/* (non-Javadoc)
	 * @see fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring.Item#hasExpired()
	 */
	@Override
	public final boolean hasExpired()
	{
		return getSellIn() < 0;
	}

	@Override
	public final int getPrice(){
		return this.price;
	}

	protected boolean isPriceInBound(){
		return this.price > MIN_PRICE && this.price < MAX_PRICE;
	}


}