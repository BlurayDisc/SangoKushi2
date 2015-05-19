package com.run.sango.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javafx.concurrent.Task;

import javax.imageio.ImageIO;

import com.run.sango.model.City;
import com.run.sango.model.Force;
import com.run.sango.model.util.ExcelParser;

/**
 * Class thats loads game engine and game related data.
 * @author RuN
 *
 */
public class GameData extends Task<Void> {
	
	private static final Logger logger = Logger.getLogger("dataLogger");
	private static final String DATA_FILE_PATH = "resources/character_data.xls";
	private static final String IMAGE_RES_PATH = "resources/faces/";
	private static final int PORTRAIT = 1, LEFT_FACE = 2, RIGHT_FACE = 3;
	private static final String DEFAULT_FACE_IMAGE = "2173_2173";
	private static final String IMAGE_TYPE_JPG = ".jpg";
	private static final String SEPERATOR = "_";
	private List<Force> forces;
	private List<City> cities;
	private List<Character> characters;

	@Override
	protected Void call() throws Exception {
		
		final ExcelParser parser = new ExcelParser();
		parser.parseFile(DATA_FILE_PATH);
		parser.initDataSheets();
		logger.info("done");
		
		parser.loadCharacterData();
		logger.info("done");
		
		parser.loadCityData();
		logger.info("done");
		
		return null;
	}
	
	public BufferedImage getPortrait(String name, int faceIndex) {
		final String filename = toImagePath(name, faceIndex);
		return loadImage(filename, PORTRAIT);
	}
	
	public BufferedImage getLeftFace(String name, int faceIndex) {
		final String filename = toImagePath(name, faceIndex);
		return loadImage(filename, LEFT_FACE);
	}
	
	public BufferedImage getRightFace(String name, int faceIndex) {
		final String filename = toImagePath(name, faceIndex);
		return loadImage(filename, RIGHT_FACE);
	}
	
	private String toImagePath(String name, int faceIndex) {
		final int suffix;
		if (faceIndex < 10)
			suffix = 000;
		else if (faceIndex < 100)
			suffix = 00;
		else 
			suffix = 0;
		return suffix + faceIndex + SEPERATOR + name + SEPERATOR;
	}
	
	private BufferedImage loadImage(String filename, int facetype) {
		try {
			return ImageIO.read(
					new FileInputStream(
							IMAGE_RES_PATH + 
							filename + 
							facetype + 
							IMAGE_TYPE_JPG));
		} catch (Exception e) {
			logger.info("File: " + IMAGE_RES_PATH + filename + " " + 
					"cannot be found.");
			try {
				return ImageIO.read(
						new FileInputStream(
								IMAGE_RES_PATH + 
								DEFAULT_FACE_IMAGE + 
								facetype + 
								IMAGE_TYPE_JPG));
			} catch (Exception ignored) {
				return null;
			}
		}
	}
}