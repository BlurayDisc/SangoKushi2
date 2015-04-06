package com.run.sango.controller;

import com.run.sango.model.Character;
import com.run.sango.model.City;
import com.run.sango.view.Tile;

import java.util.ArrayList;
import java.util.List;

public class GameController {
	
	public static final List<Character> characterList = new ArrayList<>(445);
	public static final List<City> cityList = new ArrayList<>(40);
	
	public int frameWidth, frameHeight;
	public int worldWidth, worldHeight;
	
	public GameController() {

	}
	
	public static void printCharacterList() {
		for (Character character: characterList) {
			System.out.println(character);
		}
	}

	public static void printCityList() {
		for (City city: cityList) {
			System.out.println(city);
		}
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
}