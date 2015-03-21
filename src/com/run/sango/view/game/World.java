package com.run.sango.view.game;

import java.awt.Graphics;

public class World {
	
	private final int width, height;
	private final int[][] tiles;
	
	public World(int width, int height) {
		this.width = width;
		this.height = height;
		this.tiles = new int[width][height];
		fillTiles(Tile.TYPE_DIRT);
	}
	
	/**
	 * Initialises the world with the default Tile type Grass
	 */
	private void fillTiles(int type) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				tiles[i][j] = type;
			}
		}
	}
	
	/**
	 * Renders the world.
	 * @param g Graphics object.
	 */
	public void render(Graphics g) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				final Tile tile = Tile.tiles[tiles[i][j]];
				tile.draw(i * Tile.WIDTH, j * Tile.WIDTH, g);
			}
		}
	}
}
