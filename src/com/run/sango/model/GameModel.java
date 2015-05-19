package com.run.sango.model;


public abstract class GameModel {
    
	protected final int id;
    protected String name;
    
    public GameModel(int id, String name) {
    	this.id = id;
    	this.name = name;
    }
    
	/**
	 * Returns the name of this model.
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	
	public int getID() {
		return id;
	}
	
    @Override
    public String toString() {
    	return "Name[" + name + "] ID[" + id + "]";
    }

}
