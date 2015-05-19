package com.run.sango.model.battle;

import java.util.ArrayList;

public class Army extends ArrayList <Troop> {

	private static final long serialVersionUID = -2608878364711464141L;
	
	/**
	 * Checks if this Army is still alive.
	 * @return true if still being alive.
	 */
	public boolean isAlive() {
		return getSize() > 0;
	}
	
	/**
	 * Gets the total size of this Army.
	 * @return the size of the army
	 */
	public int getSize() {
		int size = 0;
		for (Troop t: this) {
			size += t.size;
		}
		return size;
	}
	
}
