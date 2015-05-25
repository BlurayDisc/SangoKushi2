package com.run.sango.model.node;

import java.util.List;

/**
 * <p> The Mappable interface provides a simple API for Nodes
 * to be attached or detached from another Node.
 * <p> Typically each node implementation is mapped to one of
 * the 8 directions.
 * <p> When attaching a Node to another Node, the value <code>
 * property</code> marks the attached location of the node and 
 * this value can also be used to retrieve the Node.
 * 
 * @author RuN
 * @since 18/15/2015
 */
public interface Mappable {

	/**
	 * Attach a Node to this Node.
	 * <p> The passed in Node is also automatically attached
	 * to the opposite value of the passed direction.
	 * @param node the Node to be attached.
	 * @param property the property of the Node.
	 */
	public void attach(Node node, Direction direction);
	
	/**
	 * Removes the Node. 
	 * <p> Also removes this node from the node that is removed
	 * during this operation, so that these two Nodes are no 
	 * longer Mapped with each other.
	 * @param node
	 */
	public void detach(Node node);
	
	/**
	 * Removes a node attached to the given direction. 
	 * <p> On successful removal operation this node itself is 
	 * also detached from the removed node.
	 * @param direction
	 */
	public void detach(Direction direction);
	
	/**
	 * Returns the relative direction to the 
	 * passed in Node.
	 * @param node a Node.
	 * @return the Direction enumeration.
	 */
	public Direction to(Node node);
	
	/**
	 * Returns the relative direction from the 
	 * passed in Node.
	 * @param node a Node.
	 * @return the Direction enumeration.
	 */
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
