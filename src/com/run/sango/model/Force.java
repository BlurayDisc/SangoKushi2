package com.run.sango.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author RuN
 */
public class Force extends GameModel {
	
    private final List<Hero> characterList = new ArrayList<>(30);
    private final List<City> cities = new ArrayList<>(5);
    private City primaryCity;
    private Color forceColour;
    private int gold;
    private int food;
    private int goldIncome;
    private int foodIncome;
    private int soldier;
    private int soldierIncome;
    private int population;
       
    public Force(int id, String name) {
    	super(id, name);
    }
    
    public String getPrimaryCity() {
        return primaryCity.getName();
    }
        
    public void increaseGold(int amount) {
        gold += amount;
    }
        
    public void increaseFood(int amount) {
        food += amount;
    }
    
    public void calcSoldier() {
        soldier = 0;        
        for (City city: cities) {
            soldier = soldier + city.getSoldiers();
        }
    }
    
    public void calcPopulation() {
        population = 0;
        for (City city: cities) {
            population = population + city.getPopulation();
        }
    }
    
    public boolean owns(City city) {
        return cities.contains(city);
    }
    
    public void add(City city) {
        cities.add(city);
    }
    
    public List<Hero> getCharacterList() {
        return characterList;
    }
    
    public List<City> getCityList() {
        return cities;
    }
        
    public String getForceName() {
        return name;
    }
    
    public void newForceName(String name) {
        this.name = name;
    }
    
    public int getGold() {
        return gold;
    }
    
    public void setGold(int gold) {
        this.gold = gold;
    }
    
    public int getFood() {
        return food;
    }
    
    public void setFood(int food) {
        this.food = food;
    }
    
    public int getSoldier() {
        return soldier;
    }
    
    public int getPopulation() {
        return population;
    }
    
    public int getGoldIncome() {
        return goldIncome;
    }
    
    public void setGoldIncome(int goldIncome) {
        this.goldIncome = goldIncome;
    }

    public int getFoodIncome() {
        return foodIncome;
    }

    public void setFoodIncome(int foodIncome) {
        this.foodIncome = foodIncome;
    }

    public int getSoldierIncome() {
        return soldierIncome;
    }

    public void setSoldierIncome(int soldierIncome) {
        this.soldierIncome = soldierIncome;
    }
    
    public void setForceColor(int r, int g, int b) {
        forceColour = new Color(r, g, b);
    }
    
    public Color getForceColor() {
        return forceColour;
    }
}