package com.run.sango.controller;

import com.run.sango.view.scene.InitScene;
import com.run.sango.view.scene.LoadScene;
import com.run.sango.view.scene.StartScene;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageController {
	
	private Stage primaryStage;
	private InitScene initScene;
	private StartScene startScene;
	private LoadScene loadScene;
	
	public StageController() {}
	
	public void addViews(Object... views) {
		
		for (Object view: views) {
			if (view instanceof Stage)
				primaryStage = (Stage) view;
			else if (view instanceof InitScene)
				initScene = (InitScene) view;
			else if (view instanceof StartScene) 
				startScene = (StartScene) view;
			else if (view instanceof LoadScene)
				loadScene = (LoadScene) view;
		}
	}
	
    public void switchScene(SceneType type) {
    	
    	final Scene scene;
    	
    	switch(type) {
			case exit: System.exit(0);
			case init: scene = initScene; break;
			case start: scene = startScene; break;
			case load: scene = loadScene; break;
			default: scene = initScene; break;
    	}
    	
    	primaryStage.setScene(scene);
    }
}