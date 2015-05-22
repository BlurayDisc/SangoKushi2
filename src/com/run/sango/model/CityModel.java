package com.run.sango.model;

import com.run.sango.model.node.Conquerable;
import com.run.sango.model.node.Dividable;
import com.run.sango.model.node.Node;

/**
 * <p> The City Model implements both Conquerable and Dividable interface.
 * <p> This allows the City Model able to lose and regain a territory. The 
 * Node class also makes the Model able to be attached to another of the 
 * same Model and form a Nodal Map.
 * @author RuN
 *
 */
public class CityModel extends Node implements Conquerable, Dividable {
	
	private byte DEFAULT_TERRITORY_COUNT = 2;
	protected byte territory = 2;
	
	@Override
	public void divide() {
		if (territory == 0)
			return;
		territory--;
	}
	
	@Override
	public void reclaim() {
		if (territory < DEFAULT_TERRITORY_COUNT)
		territory++;
	}

	@Override
	public boolean isDefeated() {
		return territory <= 0;
	}

	@Override
	public void conquer(City city) {
		city.territory--;
	}

	@Override
	public boolean isSeized(City city) {
		return city.territory == 0;
	}
}
