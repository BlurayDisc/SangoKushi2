package com.run.sango.view.scene;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

import com.run.sango.SangokushiFX;

public class GameScene extends Scene {
	
	private static final String PATH = "file:src/resources/terrain/Lords_Dirt.JPG";

	public GameScene() {
		
		super(new BorderPane(), SangokushiFX.WINDOW_WIDTH, SangokushiFX.WINDOW_HEIGHT);
		BorderPane layout = (BorderPane) super.getRoot();
		
		Circle circle = new Circle(100, Color.web("white", 0.05));
		circle.setStrokeType(StrokeType.OUTSIDE);
		circle.setStroke(Color.web("black", 0.16));
		circle.setStrokeWidth(4);
		layout.setTop(circle);
    	
    	ImageView view = new ImageView();
    	view.setImage(new Image(PATH, false));
    	layout.setBottom(view);
	}
}
