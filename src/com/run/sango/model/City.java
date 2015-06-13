package com.run.sango.model;

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
	private final Population population = new Population();
	private final Soldier soldier = new Soldier();

	public City() {
	}
	
	public void add(Hero hero) {
		heroes.put(hero.getId(), hero);
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
		return soldier.getTotal();
	}
	
	/**
	 * Gets the total number of populations.
	 * @return
	 */
	public int getPopulation() {
		return population.getTotal();
	}
	
	/**
	 * Gets the total food income of this city.
	 * @return
	 */
	public int getFoodIncome() {
		return baseFoodIncome + population.getFoodIncome();
	}
	
	/**
	 * Gets the total gold income of this city.
	 * @return
	 */
	public int getGoldIncome() {
		return baseGoldIncome + population.getGoldIncome();
	}
	
	@Override
	public String toString() {
    	final StringBuilder sb = new StringBuilder();
    	sb.append("City ").append(super.toString()).append(" ")
    	  .append("Population[").append(population.getTotal()).append("] ")
    	  .append("Soldiers[").append(soldier.getTotal()).append("]");
    	return sb.toString();
	}
}