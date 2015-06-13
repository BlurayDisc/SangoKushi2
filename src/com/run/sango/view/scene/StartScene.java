package com.run.sango.view.scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import com.run.sango.SangokushiFX;
import com.run.sango.controller.SceneType;

public class StartScene extends Scene {
	
	public StartScene() {
		
		super(new VBox(20), SangokushiFX.WINDOW_WIDTH, SangokushiFX.WINDOW_HEIGHT);
		getStylesheets().add("com/run/sango/view/menuStyle.css");
		
		VBox layout = (VBox) getRoot();
		layout.setAlignment(Pos.CENTER);
		
		ImageView imageView = new ImageView();
		
		Button startButton = new Button("Start Game");
		startButton.getStyleClass().add("button1");
		startButton.setOnAction(event -> {
			SangokushiFX.controller.switchToGameStage();
		});
		
	    Button backButton = new Button("Back");
	    backButton.getStyleClass().add("button2");
	    backButton.setOnAction(event -> {
	    	SangokushiFX.controller.switchScene(SceneType.init);
	    });
	    
	    layout.getChildren().addAll(startButton, backButton, imageView);
	}
}
