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
	
	public void execute() {
		logger.info(force.toString() + " Current State[" + state + "]");
		performAction();
		update();
		logger.info(force.toString() + " New State[" + state + "]");
	}
	
	private void performAction() {
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
		
		if (cities.size() == 0) {
			// well, we are fucked.
		}
		
		for (int i = 0; i < cities.size(); i++) {
			final City city = cities.get(i);
			if (city.getGoldIncome() < difficulty.goldIncome) {
				// find a job.
			}
			if (city.getFoodIncome() < difficulty.foodIncome) {
				// farm more rice.
			}
			if (city.getSoldiers() < 696969) {
				// breed more kids.
			}
				
		}
	}
	
	/**
	 * Performs war preparing development until it reaches the
	 * requirement for the state: Conquer.
	 */
	private void prepareForWar() {
		// THIS IS SPARTA.
	}
	
	/**
	 * Starts conquering neighboring cities, once the force
	 * owned resources falls below a certain point the state
	 * will also change.
	 */
	private void conquer() {
		// conquer ur mum.
	}

	private boolean metConquerRequirement() {
		return force.getGold() >= difficulty.conquerGold &&
			   force.getFood() >= difficulty.conquerFood &&
			   force.getTotalSoldiers() >= difficulty.conquerUnit;
	}
	
	private boolean metRepareWarRequirement() {
		return force.getGold() >= difficulty.warGold &&
			   force.getFood() >= difficulty.warFood &&
			   force.getTotalSoldiers() >= difficulty.warUnit;
	}
	
	private boolean metDefensiveRequirement() {
		// TODO Auto-generated method stub
		return false;
	}
}