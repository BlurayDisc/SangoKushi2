package com.run.sango.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
*
* <p> Description: This class contains implementation for the
* City model. 
* <p> Each City has:
* <p>	- an unique name and id.
* <p> 	- 1 to 8 neighbors.
* <p> 	- A list of Characters;
* <p> 	- Population
* <p> 	- Soldiers
* <p> 	- It's own food and gold income.
* 
* @author RuN
* @since 13/05/2015
*/
public class City extends CityModel {
	
	private int baseFoodIncome;
	private int baseGoldIncome;
	private final Map<Integer, Hero> heroes = new HashMap<>();
	private final int[] soldiers = new int[UnitType.values().length];
	private final int[] population = new int[FamilyType.values().length];

	public City() {
		Arrays.fill(soldiers, 0);
		Arrays.fill(population, 0);
	}
	
	public void add(Hero hero) {
		heroes.put(hero.id, hero);
	}
	
	/**
	 * Returns the total number of generals 
	 * in this city.
	 * @return
	 */
	public int getNumHeroes() {
		return heroes.size();
	}
	
	/**
	 * Gets the total number of soldiers.
	 * @return
	 */
	public int getSoldiers() {
		int t = 0;
		for(int s: soldiers) {
			t += s;
		}
		return t;
	}
	
	/**
	 * Gets the total number of populations.
	 * @return
	 */
	public int getPopulation() {
		int t = 0;
		for (int p: population) {
			t += p;
		}
		return t;
	}
	
	/**
	 * Gets the total food income of this city.
	 * @return
	 */
	public int getFoodIncome() {
		final int numMerchant = population[FamilyType.Merchant.index];
		return baseFoodIncome + numMerchant * 10;
	}
	
	/**
	 * Gets the total gold income of this city.
	 * @return
	 */
	public int getGoldIncome() {
		final int numFarmer = population[FamilyType.Farmer.index];
		return baseGoldIncome + numFarmer * 10;
	}
}