package com.run.sango.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RuN
 */
public class Force {
    private String forceName;
    private final List<Character> characterList = new ArrayList<>(30);
    private final List<City>  cityList = new ArrayList<>(5);
    private Color forceColour;
    private int gold;
    private int food;
    private int goldIncome;
    private int foodIncome;
    private int soldier;
    private int soldierIncome;
    private int population;
       
    public Force(String forceName) {
        this.forceName = forceName;
    }
    
    public City getPrimaryCity() {
        return cityList.get(0);
    }
    
    public String getPrimaryCityName() {
        return cityList.get(0).name;
    }
        
    public void increaseGold(int amount) {
        gold += amount;
    }
        
    public void increaseFood(int amount) {
        food += amount;
    }
    
    public void calcSoldier() {
        soldier = 0;        
        for (int i = 0; i < cityList.size(); i++) {
            soldier = soldier + cityList.get(i).soldiers.getTotal();
        }
    }
    
    public void calcPopulation() {
        population = 0;
        for (int i = 0; i < cityList.size(); i++) {
            population = population + cityList.get(i).population;
        }
    }
    
    public boolean owns(City city) {
        return cityList.contains(city);
    }
    
    public void add(City city) {
        cityList.add(city);
    }
    
    public List<Character> getCharacterList() {
        return characterList;
    }
    
    public List<City> getCityList() {
        return cityList;
    }
        
    public String getForceName() {
        return forceName;
    }
    
    public void setForceName(String name) {
        forceName = name;
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
    
    // Draw every city owned by this force
    public void drawCities(Graphics g) {
        for (int i = 0; i < cityList.size(); i++) {
            getCityList().get(i).draw(g, forceColour);
        }
    }
}
