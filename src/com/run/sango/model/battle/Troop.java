package com.run.sango.model.battle;

import com.run.sango.model.Hero;
import com.run.sango.model.UnitType;

public class Troop {
	
	private final Hero general;
	private final Hero lieutenant;
	private UnitType type;
	public int size;
	
	public Troop(Hero general, Hero lieutenant, UnitType type, int size) {
		this.general = general;
		this.lieutenant = lieutenant;
		this.type = type;
		this.size = size;
	}
	
	public Hero getGeneral() {
		return general;
	}
	
	public Hero getLieutenant() {
		return lieutenant;
	}
	
	public UnitType getUnitType() {
		return type;
	}
}
