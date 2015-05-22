package com.run.sango.model;


public abstract class GameModel {
    
	public int id;
    public String name;
    
    public GameModel(int id, String name) {
    	this.id = id;
    	this.name = name;
    }
    
    public GameModel() {
    	id = 0;
    	name = null;
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
