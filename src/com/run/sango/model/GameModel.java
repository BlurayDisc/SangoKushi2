package com.run.sango.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public abstract class GameModel {
    
	private StringProperty name;
	private IntegerProperty id;
    
    public GameModel(int id, String name) {
		this.name = new SimpleStringProperty(name);
		this.id = new SimpleIntegerProperty(id);
    }
    
    public GameModel() {
		this.name = new SimpleStringProperty();
		this.id = new SimpleIntegerProperty();
    }
    
    public IntegerProperty getIdProperty() {
    	return id;
    }
	
	public void setId(int id) {
		this.id.set(id);
	}
	
	public void setName(String name) {
		this.name.set(name);
	}
    
	/**
	 * Returns the name of this model.
	 * @return
	 */
	public String getName() {
		return name.get();
	}
	
	
	public int getId() {
		return id.get();
	}
	
    @Override
    public String toString() {
    	final StringBuilder sb = new StringBuilder();
    	sb.append("Name[").append(name).append("] ")
		  .append("ID[").append(id).append("]");
    	return sb.toString();
    }
}
