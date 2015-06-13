package com.run.sango.model.node;


/**
 * Models which implements the Conquerable interface are able 
 * to conquer a Model that also implements the Dividable 
 * interface. The isSeized() methods can be used to check on
 * that Dividable Model to see if it has been fully seized by
 * this Conquerable model.
 * @author RuN
 */
public interface Conquerable {
	
	public void conquer(Dividable dividable);
	
	public boolean isSeized(Dividable dividable);
}
