package com.run.sango.model;

public class Population extends AbstractCollection {
	
	public Population() {
		super(FamilyType.values().length);
	}
	
	/**
	 * Gets the total food income of this city.
	 * @return
	 */
	public int getFoodIncome() {
		final int numMerchant = get(FamilyType.Merchant.index);
		return numMerchant * 10;
	}
	
	/**
	 * Gets the total gold income of this city.
	 * @return
	 */
	public int getGoldIncome() {
		final int numFarmer = get(FamilyType.Farmer.index);
		return numFarmer * 10;
	}
}
