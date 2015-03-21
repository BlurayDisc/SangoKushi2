package com.run.sango.view.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tile {
	
	public static final int WIDTH = 64, HEIGHT = 64;
	
	public static final int TYPE_DIRT = 0;
	public static final int TYPE_GRASS = 1;
	public static final Tile[] tiles = new Tile[5];
	
	private final BufferedImage tileImage;
	
	static {
		tiles[TYPE_DIRT] = new Tile("Lords_Dirt.JPG");
		tiles[TYPE_GRASS] = new Tile("Lords_Grass.JPG");
	}
	
	public Tile(String filename) {
		this.tileImage = loadBufferedImage(filename);
	}
	
	private BufferedImage loadBufferedImage(String filename) {
		try {
			return ImageIO.read(new File("resources/terrain/" + filename));
		} catch (IOException e) {return null;}
	}
	
	private BufferedImage genRandomTile() {
		
		final int randX = (int) (Math.random() * 4) + 4;
		final int randY = (int) (Math.random() * 4);
		final BufferedImage randomImage = tileImage.getSubimage(randX * WIDTH, randY * HEIGHT, WIDTH, HEIGHT);
		return randomImage;
	}
	
	public void draw(int x, int y, Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(genRandomTile(), x, y, null);
	}
}