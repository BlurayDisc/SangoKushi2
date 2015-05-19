package com.run.sango.model.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import com.run.sango.controller.GameController;
import com.run.sango.model.Character;
import com.run.sango.model.City;
import com.run.sango.model.UnitType;

/**
 * <p> This class uses the Apache poi API for parsing an .xls file.
 * Data sheets are created from an Excel work book and then read
 * in the application's memory. 
 * <p> Character and City object are  created by using the data 
 * from the excel file.
 * 
 * @author RuN
 * @since 08/03/2015
 */
public class ExcelParser {

	private static final Logger logger = Logger.getLogger("parserLogger");
	private static final String FILE_NAME = "resources/character_data.xls";
	private HSSFSheet characterSheet;
	private HSSFSheet citySheet;
	
	/**
	 * Loads the excel work book and it's excel sheets into the memory.
	 * <p> Parses the excel data into the system's memory from each of 
	 * the attached Excel Sheets.
	 */
	public void initDataSheets() {
		
		initLogger();
		
		try (
			final InputStream is = new FileInputStream(FILE_NAME);
			HSSFWorkbook excelWorkBook = new HSSFWorkbook(is) ) {
			
			logger.info(excelWorkBook.getClass().getSimpleName() + " - " + 
					"successfully read from file: " + FILE_NAME);
			
			characterSheet = excelWorkBook.getSheet("character");
			logger.info(characterSheet.getClass().getSimpleName() + ": " + 
					characterSheet.getSheetName() + " - loaded.");
			
			citySheet = excelWorkBook.getSheet("city");
			logger.info(citySheet.getClass().getSimpleName() + ": " + 
					citySheet.getSheetName() + " - loaded.");
			
		} catch (IOException ioe) {
			logger.warning("Unable to locate file: " + FILE_NAME + ioe.getCause());
		} finally {
			logger.info(HSSFWorkbook.class.getSimpleName() + " " +
					FILE_NAME + " " + "successfully closed.");
		}
	}
	
	public void parseFile(String path) {
		
	}
	
	private static void initLogger() {
//		java.util.logging.MemoryHandler.level=INFO;
//		java.util.logging.MemoryHandler.formatter=java.util.logging.SimpleFormatter;
		final Handler handler = new ConsoleHandler();
		handler.setLevel(Level.FINEST);
		final Formatter formatter = new SimpleFormatter();
		handler.setFormatter(formatter);
		logger.addHandler(handler);
	}

	/**
	 * Parses the Character data from the Excel file.
	 */
	public void loadCharacterData() {
		final List<Character> list = new ArrayList<>(500);
        for (int i = 1; i < 585; i++) {
        	final Character c = createCharacter(i);
        	list.add(c);
        	logger.finest(c.toString());
        }
       final GameController gc = GameController.getInstance();
       gc.setCharacterData(list);
    }
	
	/**
	 * Parses the City data from the excel sheet.
	 */
	public void loadCityData() {
		final List<City> list = new ArrayList<>(40);
		for (int i = 1; i < 41; i++) {
	    	final Row row = citySheet.getRow(i);
	    	final int id = (int) row.getCell(0).getNumericCellValue();
	    	final String name = row.getCell(1).getStringCellValue();
	    	final City c = new City(id, name);
	    	list.add(c);
	    	logger.finest(c.toString());
		}
		final GameController gc = GameController.getInstance();
		gc.setCityData(list);
	}
	
	/**
	 * Creates a single character, it's attributes are parsed from the excel sheet 
	 * and then stored to a new General object.
	 * @param i The position (in terms of rows) of this specific character in the 
	 * excel sheet.
	 * @return The General (Character)
	 */
	private Character createCharacter(int i) {
		
    	final Row row = characterSheet.getRow(i);
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
	
	private UnitType parseType(String rawType) {
		final UnitType type;
		switch(rawType) {
			case "枪兵": type = UnitType.SpearMan; break;
			case "骑兵": type = UnitType.LightCalvary; break;
			case "弓兵": type = UnitType.Archer; break;
			default: type = UnitType.SpearMan; break;
		}
		return type;
	}
}