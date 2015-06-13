package com.run.sango.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Hero extends GameModel {

	private final IntegerProperty leadership;
	private final IntegerProperty strength;
	private final IntegerProperty intelligence;
	private final IntegerProperty politics;
    
	public UnitType armyType;
	public Ability ability;
	public int imageIndex;
	public String location;
	
	public Hero() {

		leadership = new SimpleIntegerProperty();
		strength = new SimpleIntegerProperty();
		intelligence = new SimpleIntegerProperty();
		politics = new SimpleIntegerProperty();
	}
	
	public void setLeadership(int leadership) {
		this.leadership.set(leadership);
	}
	
	public void setStrength(int strength) {
		this.strength.set(strength);
	}
	
	public void setIntelligence(int intelligence) {
		this.intelligence.set(intelligence);
	}
	
	public void setPolitics(int politics) {
		this.politics.set(politics);
	}
	
	public ObjectProperty<Integer> getLeaderShipProperty() {
		return leadership.asObject();
	}
	
	public ObjectProperty<Integer> getStrengthProperty() {
		return strength.asObject();
	}
	
	public ObjectProperty<Integer> getIntelligenceProperty() {
		return intelligence.asObject();
	}
	
	public ObjectProperty<Integer> getPoliticsProperty() {
		return politics.asObject();
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