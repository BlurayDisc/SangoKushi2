package com.run.sango.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public abstract class GameUnit {
	
    public final int length = 25;
    public final int offset = 1;
    // city location on GamePanel, x-coordinate and y-coordinate
    public int x, y;
    public final Rectangle2D rectangle = new Rectangle2D.Double(x, y, length, length);
	protected Shape shape;
	
	public GameUnit() {
		
	}
	
	public void init(int x, int y) {
		this.x = x;
		this.y = y;
		this.shape = new Polygon ();
	}
	
	public void render(Graphics g) {
		
		Color forceColour = Color.BLACK;
		
        // convert to Graphics2D
        Graphics2D g2 = (Graphics2D)g;
        
        // set border size
        g2.setStroke(new BasicStroke(2));

        // fill the square
        g2.setPaint(forceColour);
        g2.fill(rectangle);
        
        // upper line
        g2.setPaint(forceColour.brighter());
        g2.drawLine(x + offset, y + offset, x + length, y + offset);
        
        // bottom line
        g2.setPaint(forceColour.darker());
        g2.drawLine(x + offset, y + length, x + length - offset, y + length);
        
        // left line
        g2.setPaint(forceColour.darker());
        g2.drawLine(x + offset, y + offset, x + offset, y + length);
        
        // right line
        g2.setPaint(forceColour.brighter());
        g2.drawLine(x + length, y + offset, x + length, y + length);
        
        // making the button more 3D.
        g2.setStroke(new BasicStroke(1));
        g2.setPaint(forceColour.brighter());
        g2.drawLine(x + offset, y, x + offset + offset, y);
        g2.setPaint(forceColour.darker());
        g2.drawLine(x + length - offset - offset, y + length, x + length - offset, y + length);
		
	}
	
    public void drawPressed(Graphics g, Color forceColour) {
        
        // convert to Graphics2D
        Graphics2D g2 = (Graphics2D)g;
        
        // set border size
        g2.setStroke(new BasicStroke(2));

        // fill the square
        g2.setPaint(forceColour);
        g2.fill(rectangle);
        
        // upper line
        g2.setPaint(forceColour.darker().darker());
        g2.drawLine(x + offset, y + offset, x + length, y + offset);
        
        // bottom line
        g2.setPaint(forceColour.darker().darker());
        g2.drawLine(x + offset, y + length, x + length - offset, y + length);
        
        // left line
        g2.setPaint(forceColour.darker().darker());
        g2.drawLine(x + offset, y + offset, x + offset, y + length);
        
        // right line
        g2.setPaint(forceColour.darker().darker());
        g2.drawLine(x + length, y + offset, x + length, y + length);
    }
}