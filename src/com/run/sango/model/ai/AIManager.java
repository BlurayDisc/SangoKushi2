package com.run.sango.model.ai;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javafx.concurrent.Task;

import com.run.sango.controller.WorkerThreadFactory;
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
	private static final Executor threadPool = 
			 			 Executors.newSingleThreadExecutor(
	 					 new WorkerThreadFactory());
	
	public AIManager() {
		init();
	}
	
	/**
	 * Creates and populates the AI list.
	 */
	private void init() {
		final List<Force> forces = GameData.getForces();
		for (int i = 0; i < forces.size(); i++)
			list.add(new AI(forces.get(i)));
	}
	
	public void executeAIs() {
		for (int i = 0; i < list.size(); i++)
			threadPool.execute(new AITask(list.get(i)));
	}
	
	private static class AITask extends Task<Void> {
		
		private final AI ai;
		
		private AITask(AI ai) {
			this.ai = ai;
		}

		@Override
		protected Void call() throws Exception {
			ai.execute();
			return null;
		}
	}
}
