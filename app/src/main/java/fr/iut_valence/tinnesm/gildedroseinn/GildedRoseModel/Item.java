package fr.iut_valence.tinnesm.gildedroseinn.GildedRoseModel;

public interface Item
{


	String getName();

	void setName(String name);

	int getSellIn();

	void setSellIn(int sellIn);

	int getQuality();

	void setQuality(int quality);

	void update();

	boolean hasExpired();

	int getPrice();
}