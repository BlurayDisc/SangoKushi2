package com.run.sango.model;

public enum FamilyType {
	
	Unsigned(0),
	Farmer(1),
	Merchant(2),
	Builder(3);
	
	public final int index;
	
	FamilyType(int index) {
		this.index = index;
	}
}