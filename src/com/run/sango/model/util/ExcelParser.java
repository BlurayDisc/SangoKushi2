package com.run.sango.model.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import com.run.sango.model.Ability;
import com.run.sango.model.City;
import com.run.sango.model.Force;
import com.run.sango.model.Hero;
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

	private static final Logger logger = LogManager.getLogger(ExcelParser.class);
	private static final String FILE_NAME = "src/resources/game_data.xls";
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
			logger.warn("Unable to locate file: " + FILE_NAME + ioe.getCause());
		} finally {
			logger.info(HSSFWorkbook.class.getSimpleName() + " " +
					FILE_NAME + " " + "successfully closed.");
		}
	}
	
	public void parseFile(String path) {
		
	}
	
	private static void initLogger() {
		
	}

	/**
	 * Parses the Character data from the Excel file.
	 */
	public List<Hero> loadHeroData() {
		final List<Hero> list = new ArrayList<>(490);
        for (int i = 1; i < 492; i++) {
        	final Hero h = new Hero();
        	list.add(h);
        	parseHeroData(h, i);
        	logger.info(h);
        }
        return list;
    }
	
	/**
	 * Parses the City data from the excel sheet.
	 */
	public List<City> loadCityData() {
		final List<City> list = new ArrayList<>(40);
		for (int i = 1; i < 42; i++) {
	    	final City c = new City();
	    	list.add(c);
	    	parseCityData(c, i);
		}
		return list;
	}
	
	public List<Force> loadForceData() {
		final List<Force> list = new ArrayList<>(30);
		return list;
	}
	
	/**
	 * Creates a single character, it's attributes are parsed from the excel sheet 
	 * and then stored to a new General object.
	 * @param index The position (in terms of rows) of this specific character in the 
	 * excel sheet.
	 */
	private void parseHeroData(Hero hero, int index) {
		
    	final Row row = characterSheet.getRow(index);
    	final int id = (int) row.getCell(0).getNumericCellValue();
    	final String name = row.getCell(1).getStringCellValue();
    	final String type = row.getCell(2).getStringCellValue();
    	final String ability = row.getCell(3).getStringCellValue();
    	final int leadership = (int) row.getCell(4).getNumericCellValue();
    	final int strength = (int) row.getCell(5).getNumericCellValue();
    	final int intelligence = (int) row.getCell(6).getNumericCellValue();
    	final int politics = (int) row.getCell(7).getNumericCellValue();
    	final int imageIndex = (int) row.getCell(8).getNumericCellValue();
    	final String location = row.getCell(9).getStringCellValue();
    	
    	hero.id = id;
    	hero.name = name;
    	hero.armyType = parseType(type);
    	hero.ability = parseAbility(ability);
    	hero.leadership = leadership;
    	hero.strength = strength;
    	hero.intelligence = intelligence;
    	hero.politics = politics;
    	hero.imageIndex = imageIndex;
    	hero.location = location;
	}
	
	private void parseCityData(City city, int index) {
    	final Row row = citySheet.getRow(index);
    	final int id = (int) row.getCell(0).getNumericCellValue();
    	final String name = row.getCell(1).getStringCellValue();
    	
    	city.id = id;
    	city.name = name;
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
	
	private Ability parseAbility(String ability) {
		return new Ability();
	}
}