package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

public abstract class AbstractItem implements Item
{
	private String name;
	private int sellIn;
	private int quality;

	public AbstractItem(String name, int sellIn, int quality)
	{
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
	}

	public void updateSellIn()
	{
		if (!"Sulfuras, Hand of Ragnaros".equals(getName()))
		{
			decrementSellIn();
		}
	}

	public final void decrementSellIn()
	{
		setSellIn(getSellIn() - 1);
	}
	
	public abstract void updateQuality();
	
	public final void increaseQualityWithinBounds()
	{
		if (getQuality() < Item.MAX_QUALITY)
			incrementQuality();
	}

	public final void decreaseQualityWithinBounds()
	{
		if (getQuality() > Item.MIN_QUALITY)		
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

}