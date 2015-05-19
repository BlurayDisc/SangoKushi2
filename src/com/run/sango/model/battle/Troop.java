package com.run.sango.model.battle;

import com.run.sango.model.Character;
import com.run.sango.model.UnitType;

public class Troop {
	
	private final Character general;
	private final Character lieutenant;
	private UnitType type;
	public int size;
	
	public Troop(Character general, Character lieutenant, UnitType type, int size) {
		this.general = general;
		this.lieutenant = lieutenant;
		this.type = type;
		this.size = size;
	}
	
	public Character getGeneral() {
		return general;
	}
	
	public Character getLieutenant() {
		return lieutenant;
	}
	
	public UnitType getUnitType() {
		return type;
	}
}
