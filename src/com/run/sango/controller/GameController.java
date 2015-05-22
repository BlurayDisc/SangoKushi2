package com.run.sango.controller;

import com.run.sango.model.Hero;
import com.run.sango.model.City;
import com.run.sango.view.Tile;

import java.util.List;
import java.util.logging.Logger;

/**
 * The main Controller for the GameModel.
 * <p> Stores and holds game model and game engine related data.
 * 
 * @author RuN
 * @since 18/05/2015
 */
public class GameController {
	
	private static final Logger logger = Logger.getLogger(GameController.class.getSimpleName());
	private List<Hero> characterList;
	private List<City> cityList;
	
	public int frameWidth, frameHeight;
	public int worldWidth, worldHeight;
	
	private static final GameController instance = new GameController();
	
	private GameController() {}
	
	public static GameController getInstance() {
		return instance;
	}
	
	/**
	 * Sets the size of the world in terms of number of tiles.
	 * i.e. world size 5x5.
	 * @param horizontal number of tiles in the horizontal plane.
	 * @param vertial number of tiles in the vertical plane.
	 */
	public void setWorldSize(int horizontal, int vertial) {
		worldWidth = horizontal;
		worldHeight = vertial;
		frameWidth = worldWidth * Tile.WIDTH;
		frameHeight = worldHeight * Tile.HEIGHT;
	}
	
	public void setCharacterData(List<Hero> data) {
		this.characterList = data;
	}
	
	public void setCityData(List<City> data) {
		this.cityList = data;
	}
	
	public void logProgress() {
		for (Hero character: characterList) {
			logger.info(character.toString());
		}
		for (City city: cityList) {
			logger.info(city.toString());
		}
	}
}