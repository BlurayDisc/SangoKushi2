package com.run.sango.controller;

import java.util.List;

import javafx.scene.Scene;
import javafx.stage.Stage;

import com.run.sango.model.Hero;
import com.run.sango.view.scene.GameScene;
import com.run.sango.view.scene.HeroTable;
import com.run.sango.view.scene.InitScene;
import com.run.sango.view.scene.LoadScene;
import com.run.sango.view.scene.StartScene;

public class StageController {
	
	private static final StageController instance = new StageController();
	
	private Stage primaryStage;
	private Stage gameStage;
	
	private Scene initScene;
	private Scene startScene;
	private Scene loadScene;
	
	private Scene gameScene;
	
	private HeroTable heroTable;
	
	private StageController() {}
	
	public static StageController getinstance() {
		return instance;
	}
	
	public void showHeroTable(List<Hero> herolist) {
    	HeroTable heroTable = new HeroTable(herolist);
    	gameStage.setScene(heroTable);
	}
	
	/**
	 * Game Initialization.
	 * <p> Creates primary scenes.
	 * @param stage
	 */
	public void setPrimaryStage(Stage stage) {
		this.primaryStage = stage;
    	initScene = new InitScene();
    	startScene = new StartScene();
    	loadScene = new LoadScene();
    	primaryStage.setOnCloseRequest(event ->
    		System.exit(0)
    	);
	}
	
	public void switchToPrimaryStage() {
		primaryStage.show();
	}
	
	/**
	 * <p> Finalises game options and setting then 
	 * closes the primaryStage.
	 * <p> A new GameStage will be shown and 
	 */
	public void switchToGameStage() {
		primaryStage.close();
		gameStage = new Stage();
		gameScene = new GameScene();
		gameStage.setScene(gameScene);
		gameStage.show();
		gameStage.setOnCloseRequest(event ->
			System.exit(0)
		);
	}
	
    public void switchScene(SceneType type) {
    	final Scene scene;
    	switch(type) {
			case exit: 
				System.exit(0);
			case init: 
				scene = initScene; 
				break;
			case start: 
				scene = startScene; 
				break;
			case load: 
				scene = loadScene; 
				break;
			case heroTable: 
				scene = heroTable;
				break;
			default: 
				scene = initScene; 
				break;
    	}
    	primaryStage.setScene(scene);
    }
}