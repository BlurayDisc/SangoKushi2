package com.run.sango;

import com.run.sango.controller.StageController;
import com.run.sango.view.scene.InitScene;
import com.run.sango.view.scene.LoadScene;
import com.run.sango.view.scene.StartScene;

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
	public static final StageController controller = new StageController();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    	
    	this.primaryStage = primaryStage;
    	final InitScene initScene = new InitScene();
    	final StartScene startScene = new StartScene();
    	final LoadScene loadScene = new LoadScene();
    	
    	controller.addViews(primaryStage, initScene, startScene, loadScene);

        primaryStage.setScene(initScene);
        primaryStage.show();
    }
}