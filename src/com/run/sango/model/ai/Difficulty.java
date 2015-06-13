package com.run.sango.model.ai;

public enum Difficulty {

	EASY(0),
	MEDIUM(3),
	HARD(5),
	INSANE(10);
	
	static final int FOOD_INCOME_FLOOR = 2000;
	static final int GOLD_INCOME_FLOOR = 2000;
	
	// EASY
	static final int WAR_GOLD_REQUIREMENT = 10000;
	static final int WAR_FOOD_REQUIREMENT = 10000;
	static final int WAR_UNIT_REQUIREMENT = 10000;
	
	static final int CONQUER_GOLD_REQUIREMENT = 10000;
	static final int CONQUER_FOOD_REQUIREMENT = 10000;
	static final int CONQUER_UNIT_REQUIREMENT = 10000;
	
	public final int conquerGold, conquerFood, conquerUnit;
	public final int warGold, warFood, warUnit;
	public final int foodIncome, goldIncome;
	
	Difficulty(int level) {
		this.conquerGold = CONQUER_GOLD_REQUIREMENT + level * 1000;
		this.conquerFood = CONQUER_FOOD_REQUIREMENT + level * 1000;
		this.conquerUnit = CONQUER_UNIT_REQUIREMENT + level * 1000;
		this.warGold = WAR_GOLD_REQUIREMENT + level * 1000;
		this.warFood = WAR_FOOD_REQUIREMENT + level * 1000;
		this.warUnit = WAR_UNIT_REQUIREMENT + level * 1000;
		this.foodIncome = FOOD_INCOME_FLOOR + level * 1000;
		this.goldIncome = GOLD_INCOME_FLOOR + level * 1000;
	}
}