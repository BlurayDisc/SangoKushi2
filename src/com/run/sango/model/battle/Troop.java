package com.run.sango.model.battle;

import com.run.sango.model.General;
import com.run.sango.model.UnitType;

public class Troop {
	
	private final General general;
	private final General lieutenant;
	private UnitType type;
	public int size;
	
	public Troop(General general, General lieutenant, UnitType type, int size) {
		this.general = general;
		this.lieutenant = lieutenant;
		this.type = type;
		this.size = size;
	}
	
	public General getGeneral() {
		return general;
	}
	
	public General getLieutenant() {
		return lieutenant;
	}
	
	public UnitType getUnitType() {
		return type;
	}
}
