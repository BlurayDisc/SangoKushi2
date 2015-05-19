package com.run.sango.model;

public class General extends GameModel {

	public UnitType armyType;
	public byte leadership, strength, intelligence, politics;
	public int imageIndex;
	
	public General(int id, String name) {
		super(id, name);
	}
	
	@Override
	public String toString() {
		return super.toString() + " " +
			"Army[" + armyType + "] " +
			"Leader[" + leadership + "] " +
			"Strength[" + strength + "] " +
			"Intelligence[" + intelligence + "] " +
			"Politics[" + politics + "]";
	}
}