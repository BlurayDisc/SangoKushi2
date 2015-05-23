package com.run.sango.model.ai;

public class Difficulty {
	
	static final int FOOD_INCOME_FLOOR = 2000;
	static final int GOLD_INCOME_FLOOR = 2000;
	
	// EASY
	static final int WAR_GOLD_REQUIREMENT = 10000;
	static final int WAR_FOOD_REQUIREMENT = 10000;
	static final int WAR_UNIT_REQUIREMENT = 10000;
	
	static final int CONQUER_GOLD_REQUIREMENT = 10000;
	static final int CONQUER_FOOD_REQUIREMENT = 10000;
	static final int CONQUER_UNIT_REQUIREMENT = 10000;
	
	public static final Difficulty EASY = new Difficulty(
			CONQUER_GOLD_REQUIREMENT, CONQUER_FOOD_REQUIREMENT, CONQUER_UNIT_REQUIREMENT,
			WAR_GOLD_REQUIREMENT, WAR_FOOD_REQUIREMENT, WAR_FOOD_REQUIREMENT);
	
	// MEDIUM
	public static final Difficulty MEDIUM= new Difficulty(
			CONQUER_GOLD_REQUIREMENT, CONQUER_FOOD_REQUIREMENT, CONQUER_UNIT_REQUIREMENT,
			WAR_GOLD_REQUIREMENT, WAR_FOOD_REQUIREMENT, WAR_FOOD_REQUIREMENT);
	// HARD
	public static final Difficulty HARD= new Difficulty(
			CONQUER_GOLD_REQUIREMENT, CONQUER_FOOD_REQUIREMENT, CONQUER_UNIT_REQUIREMENT,
			WAR_GOLD_REQUIREMENT, WAR_FOOD_REQUIREMENT, WAR_FOOD_REQUIREMENT);
	
	// INSANE
	public static final Difficulty INSANE = new Difficulty(
			CONQUER_GOLD_REQUIREMENT, CONQUER_FOOD_REQUIREMENT, CONQUER_UNIT_REQUIREMENT,
			WAR_GOLD_REQUIREMENT, WAR_FOOD_REQUIREMENT, WAR_FOOD_REQUIREMENT);
	
	public final int cGold, cFood, cUnit;
	public final int wGold, wFood, wUnit;
	
	Difficulty(int cgold, int cfood, int cunit, 
			   int wGold, int wFood, int wUnit) {
		this.cGold = cgold;
		this.cFood = cfood;
		this.cUnit = cunit;
		this.wGold = wGold;
		this.wFood = wFood;
		this.wUnit = wUnit;
	}
}
