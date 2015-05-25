package com.run.sango.model.node;

/**
 * A list of Direction enumerations. It is used by the
 * NodeMap implementation.
 * <p> Contains the opposite() method which returns the
 * opposite of itself.
 * @author RuN
 *
 */
public enum Direction {
	
	NORTH, 
	SOUTH, 
	WEST, 
	EAST, 
	NORTH_WEST,
	NORTH_EAST, 
	SOUTH_WEST, 
	SOUTH_EAST;
	
	/**
	 * Returns the opposite direction to this.
	 * @return
	 */
    public Direction opposite() {
        switch(this) {
            case NORTH: return Direction.SOUTH;
            case SOUTH: return Direction.NORTH;
            case EAST: return Direction.WEST;
            case WEST: return Direction.EAST;
            case NORTH_WEST: return Direction.SOUTH_EAST;
            case NORTH_EAST: return Direction.SOUTH_WEST;
            case SOUTH_WEST: return Direction.NORTH_EAST;
            case SOUTH_EAST: return Direction.NORTH_WEST;
            default:
            	throw new IllegalArgumentException(
    			"Whoops, it should never reach me down here!");
        }
    }
}	
