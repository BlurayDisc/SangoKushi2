package com.run.sango.view;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Tile {
	
	public static final int WIDTH = 64, HEIGHT = 64;
	
	public static final int TYPE_DIRT = 0;
	public static final int TYPE_DIRT_GRASS = 1;
	public static final int TYPE_DIRT_ROUGH = 2;
	public static final int TYPE_GRASS = 3;
	public static final int TYPE_GRASS_DARK = 4;
	public static final int TYPE_ROCK = 5;
	public static final Tile[] tiles = new Tile[6];
	
	private BufferedImage tileImage;
	
	static {
		tiles[TYPE_DIRT] = new Tile("Lords_Dirt.JPG");
		tiles[TYPE_DIRT_GRASS] = new Tile("Lords_DirtGrass.JPG");
		tiles[TYPE_DIRT_ROUGH] = new Tile("Lords_DirtRough.JPG");
		tiles[TYPE_GRASS] = new Tile("Lords_Grass.JPG");
		tiles[TYPE_GRASS_DARK] = new Tile("Lords_GrassDark.JPG");
		tiles[TYPE_ROCK] = new Tile("Lords_Rock.JPG");
	}
	
	public Tile(String filename) {
		try (InputStream is = new FileInputStream("resources/terrain/" + filename)) {
			tileImage = ImageIO.read(is);
		} catch (IOException ignored) {}
	}
	
	public void render(int x, int y, Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(genRandomTile(), x, y, null);
	}
	
	private BufferedImage genRandomTile() {
		
		final int randX = (int) (Math.random() * 4) + 4;
		final int randY = (int) (Math.random() * 4);
		final BufferedImage randomImage = tileImage.getSubimage(randX * WIDTH, randY * HEIGHT, WIDTH, HEIGHT);
		return randomImage;
	}
}