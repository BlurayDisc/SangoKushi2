package com.run.sango.view;

import java.awt.Graphics;

public abstract class GameObject {
	
	protected int x = 0, y = 0;
	
	public GameObject() {
		
	}
	
	public abstract void update();
	public abstract void render(Graphics g);

}