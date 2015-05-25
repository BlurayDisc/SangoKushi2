package com.run.sango.model.node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.run.sango.model.GameModel;

public class Node extends GameModel implements Mappable {
	
	private final Map<Direction, Node> neighbours = new HashMap<>();
	
	@Override
	public void attach(Node node, Direction direction) {
		if (node == null || direction == null)
			throw new IllegalArgumentException(
			"The passed in Node has not been initialised!");
		neighbours.put(direction, node);
		node.neighbours.put(direction.opposite(), this);
	}
	
	@Override
	public void detach(Direction direction) {
		final Node node = neighbours.remove(direction);
		if (node == null) 
			throw new IllegalArgumentException(
			"This node is not attached to the passed in direction value");
		node.neighbours.remove(direction.opposite());
	}
	
	@Override
	public void detach(Node node) {
		if (!neighbours.values().remove(node))
			throw new IllegalArgumentException(
				"The passed in Node has not been initialised!");
		node.neighbours.values().remove(this);
	}
	
	@Override
	public Node retrieveNode(Direction property) {
		return neighbours.get(property);
	}

	@Override
	public List<Node> getNodes() {
		return (List<Node>) neighbours.values();
	}
	
	@Override
	public Direction from(Node node) {
		for(final Direction d: neighbours.keySet()) {
			if (neighbours.get(d) == node)
				return d;
		}
		throw new IllegalArgumentException(
		"This node is not attached to the passed in direction value");
	}
	
	@Override
	public Direction to(Node node) {
		return from(node).opposite();
	}
	
	@Override
	public String toString() {
		return "Attached Nodes: " + neighbours.toString();
	}
}