package com.run.sango.view;

import java.io.FileInputStream;
import java.io.InputStream;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeType;

public class GameScene extends Scene {

	public GameScene(double width, double height) {
		
		super(null, width, height);
		
		StackPane layout = new StackPane();
		setRoot(layout);
		
		Circle circle = new Circle(150, Color.web("white", 0.05));
		circle.setStrokeType(StrokeType.OUTSIDE);
		circle.setStroke(Color.web("white", 0.16));
		circle.setStrokeWidth(4);
		layout.getChildren().add(circle);

        Polygon polygon = new Polygon();
        try (InputStream is = new FileInputStream("resources/terrain/Lords_Dirt.JPG") ){
        	polygon.setFill(new ImagePattern(new Image(is)));
        } catch (Exception ign) {ign.printStackTrace();}
        layout.getChildren().add(polygon);
	}

}
