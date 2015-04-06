package com.run.sango;

import com.run.sango.controller.initController;
import com.run.sango.view.InitScene;
import com.run.sango.view.LoadScene;
import com.run.sango.view.StartScene;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class for the Application, first UI in JAVA FX.
 * Created by RuN on 27/03/2015.
 */
public class SangokushiFX extends Application {
	
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	
	public Stage primaryStage;
	public static final initController controller = new initController();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    	
    	this.primaryStage = primaryStage;
    	InitScene initScene = new InitScene();
    	StartScene startScene = new StartScene();
    	LoadScene loadScene = new LoadScene();
    	
    	controller.addViews(primaryStage, initScene, startScene, loadScene);

        primaryStage.setScene(initScene);
        primaryStage.show();
    }
}