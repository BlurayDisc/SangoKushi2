package com.run.sango.controller.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

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
 * <p> This class uses the Apache POI API for parsing an .xls file.
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
	
	private static final String FILE_READ_SUCCESS = " - successfully read from file: ";
	private static final String FILE_READ_FAIL = "Unable to locate file: ";
	private static final String FILE_CLOSE_SUCCESS = " successfully closed.";
	
	private static final String HERO_SHEET_NAME = "hero";
	private static final String CITY_SHEET_NAME = "city";
	private static final String FORCE_SHEET_NAME = "force";
	private static final String SHEET_READ_SUCCESS = " - loaded.";

	private HSSFSheet heroSheet;
	private HSSFSheet citySheet;
	private HSSFSheet forceSheet;

	public void parseFile(String path) {
		try (
			InputStream is = new FileInputStream(path);
			HSSFWorkbook excelWorkBook = new HSSFWorkbook(is) ) {
			logger.info(excelWorkBook.getClass().getSimpleName() + 
					FILE_READ_SUCCESS + path);
			initDataSheets(excelWorkBook);
		} catch (IOException ioe) {
			logger.warn(FILE_READ_FAIL + path + ioe.getCause());
		} finally {
			logger.info(HSSFWorkbook.class.getSimpleName() + " " +
					path + FILE_CLOSE_SUCCESS);
		}
	}
	
	/**
	 * Loads the excel work book and it's excel sheets into the memory.
	 * <p> Parses the excel data into the system's memory from each of 
	 * the attached Excel Sheets.
	 */
	private void initDataSheets(HSSFWorkbook excelWorkBook) {
		heroSheet = excelWorkBook.getSheet(HERO_SHEET_NAME);
		logger.info(
				heroSheet.getClass().getSimpleName() + ": " + 
				heroSheet.getSheetName() + SHEET_READ_SUCCESS);
		
		citySheet = excelWorkBook.getSheet(CITY_SHEET_NAME);
		logger.info(
				citySheet.getClass().getSimpleName() + ": " + 
				citySheet.getSheetName() + SHEET_READ_SUCCESS);
		
		forceSheet = excelWorkBook.getSheet(FORCE_SHEET_NAME);
		logger.info(
				forceSheet.getClass().getSimpleName() + ": " + 
				forceSheet.getSheetName() + SHEET_READ_SUCCESS);
	}

	/**
	 * Parses the Character data from the Excel file.
	 */
	public void loadHeroData(ArrayList<Hero> list) {
		final int rows = heroSheet.getPhysicalNumberOfRows();
		list.ensureCapacity(rows - 1);
        for (int i = 1; i < rows; i++) {
        	final Hero h = new Hero();
        	list.add(h);
        	parseHeroData(h, i);
        }
    }
	
	/**
	 * Parses the City data from the excel sheet.
	 */
	public void loadCityData(ArrayList<City> list) {
		final int rows = citySheet.getPhysicalNumberOfRows();
		list.ensureCapacity(rows - 1);
		for (int i = 1; i < rows; i++) {
	    	final City c = new City();
	    	list.add(c);
	    	parseCityData(c, i);
		}
	}
	
	public void loadForceData(ArrayList<Force> list) {
		final int rows = forceSheet.getPhysicalNumberOfRows();
		list.ensureCapacity(rows - 1);
		for (int i = 1; i < rows; i++) {
	    	final Force f = new Force();
	    	list.add(f);
	    	parseForceData(f, i);
		}
	}
	
	/**
	 * Creates a single character, it's attributes are parsed from the excel sheet 
	 * and then stored to a new General object.
	 * @param index The position (in terms of rows) of this specific character in the 
	 * excel sheet.
	 */
	private void parseHeroData(Hero hero, int index) {
		
    	final Row row = heroSheet.getRow(index);
    	final int id = (int) row.getCell(0).getNumericCellValue();
    	final String name = row.getCell(1).getStringCellValue();
    	final String rawtype = row.getCell(2).getStringCellValue();
    	final String ability = row.getCell(3).getStringCellValue();
    	final int leadership = (int) row.getCell(4).getNumericCellValue();
    	final int strength = (int) row.getCell(5).getNumericCellValue();
    	final int intelligence = (int) row.getCell(6).getNumericCellValue();
    	final int politics = (int) row.getCell(7).getNumericCellValue();
    	final int imageIndex = (int) row.getCell(8).getNumericCellValue();
    	final String location = row.getCell(9).getStringCellValue();
    	
    	hero.setId(id);
    	hero.setName(name);
    	hero.armyType = parseType(rawtype);
    	hero.ability = parseAbility(ability);
    	hero.setLeadership(leadership);
    	hero.setStrength(strength);
    	hero.setIntelligence(intelligence);
    	hero.setPolitics(politics);
    	hero.imageIndex = imageIndex;
    	hero.location = location;
	}
	
	private void parseCityData(City city, int index) {
    	final Row row = citySheet.getRow(index);
    	final int id = (int) row.getCell(0).getNumericCellValue();
    	final String name = row.getCell(1).getStringCellValue();
    	
    	city.setId(id);
    	city.setName(name);
	}
	
	private void parseForceData(Force force, int index) {
    	final Row row = forceSheet.getRow(index);
    	final int id = (int) row.getCell(0).getNumericCellValue();
    	final String name = row.getCell(1).getStringCellValue();
    	
    	force.setId(id);
    	force.setName(name);
	}
	
	private UnitType parseType(String rawType) {
		final UnitType type;
		switch(rawType) {
			case UnitType.SPEAR_MAN_CN: 
				type = UnitType.SpearMan; 
				break;
			case UnitType.CALVARY_CN: 
				type = UnitType.LightCalvary; 
				break;
			case UnitType.ARHCER_CN: 
				type = UnitType.Archer; 
				break;
			default: 
				type = UnitType.SpearMan; 
				break;
		}
		return type;
	}
	
	private Ability parseAbility(String ability) {
		return new Ability();
	}
}