package com.run.sango.model.node;

/**
 * <p> The Dividable interface is in conjunction to the Conquerable interface.
 * <p> This interface makes the object implementing it able to divide itself
 * into fragments or reclaim back a missing fragment of it's own.
 * @author RuN
 * @since 19/05/2015
 */
public interface Dividable {

	/**
	 * Removes a territory from this city.
	 */
	public void divide();
	
	/**
	 * If the number of territory in this city reaches
	 * zero, this city is defeated.
	 * @return True if defeated (t == 0)
	 */
	public boolean isDefeated();
	
	/**
	 * Reclaims a territory owned by this city.
	 * The
	 */
	public void reclaim();
}
