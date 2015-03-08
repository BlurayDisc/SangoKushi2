package com.run.sango.model;

public class Character {

	public int id;
	public final String name;
	public ArmyType armyType;
	public byte leadership, strength, intelligence, politics;
	
	public Character(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + " Army: " + armyType + " Leader: " + leadership + " Strength: " + strength +
				" Intelligence: " + intelligence + " Politics: " + politics;
	}
}