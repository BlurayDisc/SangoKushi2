package com.run.sango.model.ai;

import java.util.LinkedList;
import java.util.List;

import com.run.sango.controller.data.GameData;
import com.run.sango.model.Force;

/**
 * The AI manager keeps tracks of all the force AIs and executes
 * each and every of them (contained in the linked list) every
 * turn.
 * @author RuN
 *
 */
public class AIManager {

	private static final LinkedList<AI> list = new LinkedList<>();
	
	public AIManager() {
		init();
	}
	
	/**
	 * Creates and populates the AI list.
	 */
	private void init() {
		final List<Force> forces = GameData.getForces();
		for (int i = 0; i < forces.size(); i++) {
			list.add(new AI(forces.get(i)));
		}
	}
	
	public void performLogics() {
		for (final AI ai: list) {
			ai.performLogics();
		}
	}
}
