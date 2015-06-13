package com.run.sango.view.scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import com.run.sango.SangokushiFX;
import com.run.sango.controller.SceneType;

public class LoadScene extends Scene {
	
	public LoadScene() {
		
		super(new VBox(20), SangokushiFX.WINDOW_WIDTH, SangokushiFX.WINDOW_HEIGHT);
		getStylesheets().add("com/run/sango/view/menuStyle.css");
		
		VBox layout = (VBox) getRoot();
		layout.setAlignment(Pos.CENTER);
		
		Button entry1 = new Button("Entry 1");
		entry1.getStyleClass().add("button1");
		
		Button entry2 = new Button("Entry 2");
		entry2.getStyleClass().add("button1");
		
		Button entry3 = new Button("Entry 3");
		entry3.getStyleClass().add("button1");
		
	    Button backButton = new Button("Back");
	    backButton.getStyleClass().add("button2");
	    backButton.setOnAction(event -> 
	    	SangokushiFX.controller.switchScene(SceneType.init)
    	);
	    layout.getChildren().addAll(entry1, entry2, entry3, backButton);
	}
}