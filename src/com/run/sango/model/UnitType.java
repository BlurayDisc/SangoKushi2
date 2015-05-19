package com.run.sango.model;

public enum UnitType {
	
	Archer(0),
	CrossBow(1),
	Chariot(2),
	
	LightCalvary(3),
	HeavyCavalry(4),
	TurkCalvary(5),
	WhiteCalvary(6),
	TigerCalvary(7),
	
	SpearMan(8),
	SwordsMan(9),
	LongSword(10),
	Shield(11),
	RattanArmour(12),
	YellowTurbanTroops(13),
	QingZhouTroops(14),
	Halberdier(15);
	
	public final int index;
	
	UnitType(int index) {
		this.index = index;
	}
}