package com.run.sango.view.scene;

import com.run.sango.SangokushiFX;
import com.run.sango.controller.SceneType;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LoadScene extends Scene {
	
	public LoadScene() {
		
		super(new VBox(20), SangokushiFX.WINDOW_WIDTH, SangokushiFX.WINDOW_HEIGHT);
		
		VBox layout = (VBox) getRoot();
		
	    Button backButton = new Button("Back");
	    backButton.setPrefSize(100, 50);
	    backButton.setOnAction(event -> 
	    	SangokushiFX.controller.switchScene(SceneType.init)
    	);
	    layout.getChildren().add(backButton);
	}
}