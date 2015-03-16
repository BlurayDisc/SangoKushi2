package com.run.sango.view.game;

import java.awt.Graphics;

public class World {
	
	private final int width, height;
	private final int[][] tiles;
	
	public World(int width, int height) {
		this.width = width;
		this.height = height;
		this.tiles = new int[width][height];
	}
	
	public void render(Graphics g) {
		
	}
}
