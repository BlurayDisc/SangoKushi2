package com.run.sango.controller;

import java.util.ArrayList;
import java.util.List;

import com.run.sango.model.City;
import com.run.sango.model.Character;

public class GameController {
	
	public static final List<Character> characterList = new ArrayList<>(445);
	public static final List<City> cityList = new ArrayList<>(40);
	
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
}