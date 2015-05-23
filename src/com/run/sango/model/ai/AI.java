package com.run.sango.model.ai;

import java.util.List;

import com.run.sango.model.City;
import com.run.sango.model.Force;
import com.sun.istack.internal.logging.Logger;

/**
 * 
 * @author RuN
 * @Since 23/05/2015
 */
public class AI {
	
	private static final Logger logger = Logger.getLogger(AI.class);

	private final Force force;
	private final Difficulty difficulty;
	private AIState state;
	private List<City> cities;
	
	public AI(Force force) {
		this.force = force;
		this.cities = force.getCityList();
		this.state = AIState.ALIVE;
		this.difficulty = Difficulty.EASY;
	}
	
	public void performLogics() {
		logger.info(force.toString() + " Current State[" + state + "]");
		perform();
		update();
		logger.info(force.toString() + " New State[" + state + "]");
	}
	
	private void perform() {
		switch(state) {
			case DEFEATED:
				break;
			case DEFENSIVE:
				break;
			case ALIVE:
				developCities();
				break;
			case PREPARE_FOR_WAR:
				prepareForWar();
				break;
			case CONQUER:
				conquer();
				break;
		}
	}

	private void update() {
		if (metConquerRequirement())
			state = AIState.CONQUER;
		else if (metRepareWarRequirement())
			state = AIState.PREPARE_FOR_WAR;
		else if (metDefensiveRequirement())
			state = AIState.DEFENSIVE;
		else
			state = AIState.ALIVE;
	}

	/**
	 * Performs a balanced city development until it reaches the
	 * requirement for entering into the war state.
	 */
	private void developCities() {
		if (cities.size() == 1) {
			
		}
		
		for (int i = 0; i < cities.size(); i++) {
			final City city = cities.get(i);
			int gold = city.getGoldIncome();
			gold = gold++;
		}
	}
	
	/**
	 * Performs war preparing development until it reaches the
	 * requirement for the state: Conquer.
	 */
	private void prepareForWar() {
		
	}
	
	/**
	 * Starts conquering neighboring cities, once the force
	 * owned resources falls below a certain point the state
	 * will also change.
	 */
	private void conquer() {
		
	}

	private boolean metConquerRequirement() {
		return force.getGold() >= difficulty.cGold &&
			   force.getFood() >= difficulty.cFood &&
			   force.getTotalSoldiers() >= difficulty.cUnit;
	}
	
	private boolean metRepareWarRequirement() {
		return force.getGold() >= difficulty.wGold &&
			   force.getFood() >= difficulty.wFood &&
			   force.getTotalSoldiers() >= difficulty.wUnit;
	}
	
	private boolean metDefensiveRequirement() {
		// TODO Auto-generated method stub
		return false;
	}
}