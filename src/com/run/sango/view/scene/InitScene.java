package com.run.sango.view.scene;

import com.run.sango.SangokushiFX;
import com.run.sango.controller.SceneType;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class InitScene extends Scene {

	public InitScene() {
		
		super(new VBox(20), SangokushiFX.WINDOW_WIDTH, SangokushiFX.WINDOW_HEIGHT);
		
		VBox layout = (VBox) getRoot();
		this.getStylesheets().add("com/run/sango/view/menuStyle.css");
		
        Text title = new Text("Sangokushi 2 FX");
        title.setFont(new Font("SansSerif", 22));
		
	    Button startButton = new Button("Start Game");
	    startButton.getStyleClass().add("button1");
	    startButton.setPrefSize(150, 50);
	    startButton.setOnAction(event -> 
	    	SangokushiFX.controller.switchScene(SceneType.start)
	    );
	    
	    Button loadButton = new Button("Load Game");
	    loadButton.getStyleClass().add("button1");
	    loadButton.setPrefSize(150, 50);
	    loadButton.setOnAction(event ->
	    	SangokushiFX.controller.switchScene(SceneType.load)
    	);
	    
	    Button exitButton = new Button("Exit Game");
	    exitButton.getStyleClass().add("button2");
	    exitButton.setPrefSize(150, 50);
	    exitButton.setOnAction(event -> 
	    	SangokushiFX.controller.switchScene(SceneType.exit)
	    );
	    
	    layout.getChildren().addAll(title, startButton, loadButton, exitButton);
	}
}