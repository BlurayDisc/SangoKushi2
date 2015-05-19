package com.run.sango.view.scene;

import com.run.sango.SangokushiFX;
import com.run.sango.controller.SceneType;
import com.run.sango.controller.data.GameData;
import com.run.sango.model.General;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class StartScene extends Scene {
	
	private int index = 0;
	
	public StartScene() {
		
		super(new VBox(20), SangokushiFX.WINDOW_WIDTH, SangokushiFX.WINDOW_HEIGHT);
		this.getStylesheets().add("com/run/sango/view/menuStyle.css");
		
		VBox layout = (VBox) getRoot();
		setRoot(layout);
		
		ImageView imageView = new ImageView();
		
		Button startButton = new Button("Start Game");
		startButton.getStyleClass().add("button1");
		startButton.setOnAction(event -> {
			GameData.load();
		});
		
		Button nextButton = new Button("Next Image");
		nextButton.getStyleClass().add("button1");
		nextButton.setOnAction(event -> {
			final General g = GameData.getGenerals().get(index);
			final Image image = GameData.getPortrait(g);
			imageView.setImage(image);
			index++;
		});
		
	    Button backButton = new Button("Back");
	    backButton.getStyleClass().add("button2");
	    backButton.setPrefSize(100, 50);
	    backButton.setOnAction(event -> 
	    	SangokushiFX.controller.switchScene(SceneType.init)
	    );
	    
	    layout.getChildren().addAll(startButton, nextButton, backButton, imageView);
	}

}
