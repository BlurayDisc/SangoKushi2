package com.run.sango.model.node;

import com.run.sango.model.City;

public interface Conquerable {
	
	public void conquer(City city);
	
	public boolean isSeized(City city);
}
