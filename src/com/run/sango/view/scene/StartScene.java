package com.run.sango.view.scene;

import com.run.sango.SangokushiFX;
import com.run.sango.controller.SceneType;
import com.run.sango.controller.data.GameData;
import com.run.sango.model.Hero;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class StartScene extends Scene {
	
	private int index = 0;
	
	public StartScene() {
		
		super(new VBox(20), SangokushiFX.WINDOW_WIDTH, SangokushiFX.WINDOW_HEIGHT);
		getStylesheets().add("com/run/sango/view/menuStyle.css");
		
		VBox layout = (VBox) getRoot();
		layout.setAlignment(Pos.CENTER);
		
		ImageView imageView = new ImageView();
		
		Button startButton = new Button("Start Game");
		startButton.getStyleClass().add("button1");
		startButton.setOnAction(event -> {
			GameData.load();
		});
		
		Button nextButton = new Button("Next Image");
		nextButton.getStyleClass().add("button1");
		nextButton.setOnAction(event -> {
			final Hero hero = GameData.getHeroes().get(index);
			final Image image = GameData.getPortrait(hero);
			imageView.setImage(image);
			index++;
		});
		
	    Button backButton = new Button("Back");
	    backButton.getStyleClass().add("button2");
	    backButton.setOnAction(event -> {
	    	SangokushiFX.controller.switchScene(SceneType.init);
			GameData.print();
	    });
	    
	    layout.getChildren().addAll(startButton, nextButton, backButton, imageView);
	}
}
