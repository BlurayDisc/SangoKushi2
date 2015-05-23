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
    private int soldierIncome;
    
    private double dispatchCostFactor = 1.0;
       
    public Force() {
    	
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
    
    public int getFoodAfterDispatch() {
    	final int s = getTotalSoldiers();
    	final double f = dispatchCostFactor;
    	return food - (int) (s * f);
    }
    
    public int getTotalSoldiers() {
        int s = 0;        
        for (int i = 0; i < cities.size(); i++) {
        	final City c = cities.get(i);
        	final int cs = c.getSoldiers();
            s += cs;
        }
        return s;
    }
    
    public int getPopulation() {
        int p = 0;
        for (int i = 0; i < cities.size(); i++) {
        	final City c = cities.get(i);
        	final int cp = c.getPopulation();
            p += cp;
        }
        return p;
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
    
    @Override
    public String toString() {
    	final StringBuilder sb = new StringBuilder();
    	sb.append("Force[").append(name).append("] ")
    	  .append("Gold[").append(gold).append("] ")
    	  .append("Food[").append(food).append("] ")
    	  .append("Soldiers[").append(getTotalSoldiers()).append("]");
    	return sb.toString();
    }
}