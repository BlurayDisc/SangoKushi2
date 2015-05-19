package com.run.sango.model.node;

import java.util.List;

/**
 * <p> The Linkedable interface provides a simple API for Nodes
 * to be attached or detached from another Node.
 * <p> When attaching a Node to another Node, the value <code>
 * property</code> marks the attached location of the node and 
 * this value can also be used to retrieve the Node.
 * @author RuN
 * @since 18/15/2015
 */
public interface Linkedable {

	enum Direction {NORTH, SOUTH, WEST, EAST, NORTH_WEST, NORTH_EAST, SOUTH_WEST, SOUTH_EAST;}
	
	/**
	 * Attach a Node to this Node.
	 * @param node the Node to be attached.
	 * @param property the property of the Node.
	 */
	public void attach(Node node, Direction property);
	
	/**
	 * Appends this Node itself to the Passed in
	 * Node and define a property for this Node.
	 * @param node
	 * @param property
	 */
	public void appendTo(Node node, Direction property);
	
	/**
	 * Removes the Node.
	 * @param node
	 */
	public void detach(Node node);
	
	/**
	 * Removes this Node itself from the
	 * passed in Node.
	 * @param node
	 */
	public void removeFrom(Node node);
	
	public Direction to(Node node);
	
	public Direction from(Node node);
	
	/**
	 * Gets the Node attached to this Node with 
	 * the passed in property.
	 * @param property
	 * @return
	 */
	public Node retrieveNode(Direction property);
	
	/**
	 * Gets a list of the Nodes attached to
	 * this Node.
	 * @return
	 */
	public List<Node> getNodes();
}
