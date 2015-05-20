package com.run.sango.controller.data;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.concurrent.Task;
import javafx.scene.image.Image;

import com.run.sango.model.General;
import com.run.sango.model.City;
import com.run.sango.model.Force;
import com.run.sango.model.util.ExcelParser;

/**
 * Class thats loads game engine and game related data.
 * @author RuN
 *
 */
public class GameData {
	
	private static final Logger logger = LogManager.getLogger(GameData.class);

	static final String DEFAULT_IMAGE = "file:src/resources/faces/0000_Со·о_";
	static final String DATA_FILE_PATH = "file:src/resources/game_data.xls";
	static final String IMAGE_RES_PATH = "file:src/resources/faces/";
	static final int PORTRAIT = 1, LEFT_FACE = 2;
	static final String IMAGE_TYPE_JPG = ".jpg";
	static final String IMAGE_TYPE_PNG = ".png";
	static final String SEPERATOR = "_";
	
	private static List<Force> forces;
	private static List<City> cities;
	private static List<General> characters;
	
	/**
	 * Loads game data in a worker thread.
	 * <p> The runnable used for the worker thread is the wrapped 
	 * static LoadGameDataTask class.
	 */
	public static void load() {
		final Thread t = new Thread(new LoadGameDataTask());
		t.setName("GameData");
		t.start();
	}
	
	public static List<Force> getForces() {
		return forces;
	}

	public static List<City> getCities() {
		return cities;
	}

	public static List<General> getGenerals() {
		return characters;
	}

	/**
	 * Loads the character body portrait.
	 * @param general The General.
	 * @return The Portrait as a javafx.scene.image object.
	 */
	public static Image getPortrait(General general) {
		final String filename = toImagePath(
				general.name, 
				general.imageIndex);
		return loadImage(filename, PORTRAIT);
	}
	
	/**
	 * Loads the character facial portrait.
	 * @param general The General.
	 * @return The Portrait as a javafx.scene.image object.
	 */
	public static Image getFacialPortrait(General general) {
		final String filename = toImagePath(
				general.name, 
				general.imageIndex);
		return loadImage(filename, LEFT_FACE);
	}
	
	/**
	 * <p> Converts the character name and image index to the 
	 * filePath of the image.
	 * <p> Image resources are located in the 
	 * <code>/resources/faces/</code> folder.
	 * @param name The character's name.
	 * @param index The portrait index of the character.
	 */
	private static String toImagePath(String name, int index) {
		final String suffix;
		if (index < 10)
			suffix = "000";
		else if (index < 100)
			suffix = "00";
		else 
			suffix = "0";
		return suffix + index + SEPERATOR + name + SEPERATOR;
	}
	
	/**
	 * <p> Loads the image based on the passed in filename and 
	 * face type.
	 * <p> If an exception occurred during this operation, the 
	 * default body/facial portrait will be returned to indicate
	 * a missing or corrupted image file. 
	 * <p> ( Default_Image_ID: 2173_2173 )
	 * @param filename the actual filename.
	 * @param facetype type of this image, body or facial.
	 * @return the Image.
	 */
	private static Image loadImage(String filename, int facetype) {
		Image img = null;
		final String filepath = IMAGE_RES_PATH + filename + 
				facetype + IMAGE_TYPE_JPG;
		final String defpath = DEFAULT_IMAGE + facetype + 
				IMAGE_TYPE_JPG;
		try {
			img = new Image(filepath, false);
			if (img == null || img.getException() != null || 
				img.getHeight() == 0) {
				logger.info(filepath + " invalid image!");
				img = new Image(defpath,  false);
			} else
				logger.info("File: " + filepath + " " + 
						"rendered successful.");
		} catch (RuntimeException e) {
			logger.info("File: " + filepath + " " +
					"cannot be found. " + e.getMessage());
			img = new Image(defpath, true);
		}
		return img;
	}
	
	static class LoadGameDataTask extends Task<Void> {
		
		LoadGameDataTask() {
			super.updateTitle("Data");
		}
		
		@Override
		protected Void call() throws Exception {
			
			final ExcelParser parser = new ExcelParser();
			parser.parseFile(DATA_FILE_PATH);
			parser.initDataSheets();
			
			characters = parser.loadCharacterData();
			cities = parser.loadCityData();
			forces = parser.loadForceData();
			
			return null;
		}
	}
}