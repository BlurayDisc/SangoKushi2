package com.run.sango.model.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import com.run.sango.controller.GameController;
import com.run.sango.model.ArmyType;
import com.run.sango.model.Character;
import com.run.sango.model.City;

/**
 * This class uses the apachi poi API for parsing an .xls file.
 * Data sheets are created from an Excel work book and then read
 * in the application's memory. Character and City object are 
 * created by using the data from the excel file.
 * 
 * @author RuN
 * @since 08/03/2015
 */
public class ExcelParser {
	
	private HSSFSheet characterData;
	private HSSFSheet cityData;
	
	/**
	 * Loads the excel work book and it's excel sheets into the memory.
	 */
	public void initDataSheets() {
		try (
			FileInputStream file = new FileInputStream(new File("resources/character_data.xls"));
			HSSFWorkbook excelFile = new HSSFWorkbook(file)) {   
			characterData = excelFile.getSheet("character");
			cityData = excelFile.getSheet("city");
		} catch (IOException ioe) {ioe.printStackTrace();}
	}

	/**
	 * Parses the Character data from the Excel file.
	 */
	public void loadCharacterData() {

        for (int i = 1; i < 445; i++) {
        	final Character c = createCharacter(i);
        	GameController.characterList.add(c);
        }
        
        for (int i = 801; i < 831; i++) {
        	final Character c = createCharacter(i);
        	GameController.characterList.add(c);
        }
        
        GameController.printCharacterList();
    }
	
	/**
	 * Parses the City data from the excel sheet.
	 */
	public void loadCityData() {
		
		for (int i = 1; i < 41; i++) {
			
	    	final Row row = cityData.getRow(i);
	    	final int id = (int) row.getCell(0).getNumericCellValue();
	    	final String name = row.getCell(1).getStringCellValue();
	    	final City c = new City(id, name);
	    	GameController.cityList.add(c);
		}
		
		GameController.printCityList();
	}
	
	/**
	 * Creates a single character, it's attributes are parsed from the excel sheet 
	 * and then stored to a new General object.
	 * @param i The position (in terms of rows) of this specific character in the 
	 * excel sheet.
	 * @return The General (Character)
	 */
	private Character createCharacter(int i) {
		
    	final Row row = characterData.getRow(i);
    	final int id = (int) row.getCell(0).getNumericCellValue();
    	final String name = row.getCell(1).getStringCellValue();
    	final byte leadership = (byte) row.getCell(19).getNumericCellValue();
    	final byte strength = (byte) row.getCell(20).getNumericCellValue();
    	final byte intelligence = (byte) row.getCell(21).getNumericCellValue();
    	final byte politics = (byte) row.getCell(22).getNumericCellValue();
    	final String type = row.getCell(27).getStringCellValue();
    	
    	final Character c = new Character(id, name);
    	c.armyType = parseType(type);
    	c.leadership = leadership;
    	c.strength = strength;
    	c.intelligence = intelligence;
    	c.politics = politics;
    	
    	return c;
	}
	
	private ArmyType parseType(String rawType) {
		final ArmyType type;
		switch(rawType) {
			case "Ç¹±ø": type = ArmyType.SpearMan; break;
			case "Æï±ø": type = ArmyType.LightCalvary; break;
			case "¹­±ø": type = ArmyType.Archer; break;
			default: type = ArmyType.SpearMan; break;
		}
		return type;
	}
}