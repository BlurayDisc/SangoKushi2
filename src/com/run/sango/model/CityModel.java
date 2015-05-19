package com.run.sango.model;

import com.run.sango.model.node.Conquerable;
import com.run.sango.model.node.Dividable;
import com.run.sango.model.node.Node;

public class CityModel extends Node implements Conquerable, Dividable {
	
	protected byte territory = 3;
	
	public CityModel(int id, String name) {
		super(id, name);
	}

	@Override
	public void divide() {
		territory--;
	}

	@Override
	public boolean isDefeated() {
		return territory == 0;
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
