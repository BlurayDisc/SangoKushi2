package com.run.sango.view.game;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.run.sango.controller.GameController;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 502121290946536395L;
	private final GameController controller;
	private final World world;

	/** Create the panel and initialise the world. */
	public GamePanel(GameController controller) {
		this.controller = controller;
		world = new World(controller.worldWidth, controller.worldHeight);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		world.render(g);
	}
}