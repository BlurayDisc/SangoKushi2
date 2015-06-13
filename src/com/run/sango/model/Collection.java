package com.run.sango.model;

public interface Collection {
	/**
	 * Gets the total sum of the items
	 * in the Collection.
	 * @return the total.
	 */
	public int getTotal();
	
	/**
	 * Sets the value for a particular index in 
	 * this collection.
	 * @param index
	 * @param amount
	 */
	public void set(int index, int amount);
	
	/**
	 * Retrieves a value with an index.
	 * @param index
	 * @return
	 */
	public int get(int index);
}
