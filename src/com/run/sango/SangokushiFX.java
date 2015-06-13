package com.run.sango;

import com.run.sango.controller.SceneType;
import com.run.sango.controller.StageController;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class for the Application, first UI in JAVA FX.
 * Created by RuN on 27/03/2015.
 */
public class SangokushiFX extends Application {
	
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	
	public static final StageController controller = StageController.getinstance();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    	
    	controller.setPrimaryStage(primaryStage);
    	controller.switchScene(SceneType.init);
    	controller.switchToPrimaryStage();
    }
}