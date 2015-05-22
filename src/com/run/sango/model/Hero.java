package com.run.sango.model;

public class Hero extends GameModel {

	public UnitType armyType;
	public Ability ability;
	public int leadership = 0, strength = 0, intelligence = 0, politics = 0;
	public int imageIndex;
	public String location;
	
	public Hero(int id, String name) {
		super(id, name);
	}
	
	public Hero() {}
	
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