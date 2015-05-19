package com.run.sango.model.node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.run.sango.model.GameModel;

public class Node extends GameModel implements Linkedable {
	
	private final Map<Direction, Node> nodemap = new HashMap<>();
	
	public Node(int id, String name) {
		super(id, name);
	}

	@Override
	public void attach(Node node, Direction property) {
		if (node == null)
			throw new IllegalArgumentException(
				"The passed in Node has not been initialised!");
		nodemap.put(property, node);
	}
	
	@Override
	public void detach(Node node) {
		if (node == null)
			throw new IllegalArgumentException(
				"The passed in Node has not been initialised!");
		nodemap.values().remove(node);
	}

	@Override
	public void appendTo(Node node, Direction property) {
		if (node == null)
			throw new IllegalArgumentException(
				"The passed in Node has not been initialised!");
		node.attach(this, property);
	}

	@Override
	public void removeFrom(Node node) {
		if (node == null)
			throw new IllegalArgumentException(
				"The passed in Node has not been initialised!");
		node.detach(this);
	}
	
	@Override
	public Direction from(Node node) {
		for(final Direction d: nodemap.keySet()) {
			if (nodemap.get(d) == node)
				return d;
		}
		return null;
	}
	
	@Override
	public Direction to(Node node) {
		if (node == null)
			throw new IllegalArgumentException(
				"The passed in Node has not been initialised!");
		return node.from(this);
	}
	
	@Override
	public Node retrieveNode(Direction property) {
		return nodemap.get(property);
	}

	@Override
	public List<Node> getNodes() {
		return (List<Node>) nodemap.values();
	}
	
	@Override
	public String toString() {
		return "Attached Nodes: " + nodemap.toString();
	}
}