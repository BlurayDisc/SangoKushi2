package com.run.sango.controller.data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javafx.concurrent.Task;
import javafx.scene.image.Image;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.run.sango.controller.WorkerThreadFactory;
import com.run.sango.model.City;
import com.run.sango.model.Force;
import com.run.sango.model.Hero;

/**
 * Class thats loads game engine and game related data.
 * @author RuN
 *
 */
public class GameData {
	
	private static final Logger logger = LogManager.getLogger(GameData.class);

	private static final String DEFAULT_IMAGE = "file:src/resources/faces/0000_Со·о_";
	private static final String DATA_FILE_PATH = "src/resources/game_data.xls";
	private static final String IMAGE_RES_PATH = "file:src/resources/faces/";
	private static final int PORTRAIT = 1, LEFT_FACE = 2;
	private static final String IMAGE_TYPE_JPG = ".jpg";
	//private static final String IMAGE_TYPE_PNG = ".png";
	private static final String SEPERATOR = "_";
	
	private static final ArrayList<Force> forces = new ArrayList<>();
	private static final ArrayList<City> cities = new ArrayList<>();
	private static final ArrayList<Hero> heroes = new ArrayList<>();
	
	private static final Executor threadPool = 
						 Executors.newSingleThreadExecutor(
						 new WorkerThreadFactory());
	
	private static boolean initialised = false;
	
	/**
	 * Loads game data in a worker thread.
	 * <p> The runnable used for the worker thread is the wrapped 
	 * static LoadGameDataTask class.
	 * <p> Short circuits the process if data has already been
	 * initialised.
	 */
	public static void load() {

		if (initialised) return;
		threadPool.execute(new GameDataTask());
	}
	
	public static List<Force> getForces() {
		return forces;
	}

	public static List<City> getCities() {
		return cities;
	}

	public static List<Hero> getHeroes() {
		return heroes;
	}

	/**
	 * Loads the character body portrait.
	 * @param general The General.
	 * @return The Portrait as a javafx.scene.image object.
	 */
	public static Image getPortrait(Hero general) {
		final String filename = toImagePath(
				general.getName(), 
				general.imageIndex);
		return loadImage(filename, PORTRAIT);
	}
	
	/**
	 * Loads the character facial portrait.
	 * @param general The General.
	 * @return The Portrait as a javafx.scene.image object.
	 */
	public static Image getFacialPortrait(Hero general) {
		final String filename = toImagePath(
				general.getName(), 
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
		
		final String filepath = IMAGE_RES_PATH + filename + 
				facetype + IMAGE_TYPE_JPG;
		final Image img = new Image(filepath, false);
		if (img == null || img.getException() != null || 
			img.getHeight() == 0) {
			logger.info(filepath + " invalid path!");
			final String defpath = DEFAULT_IMAGE + facetype + 
					IMAGE_TYPE_JPG;
			return new Image(defpath, false);
		}
		logger.info(filepath + " rendered successful.");
		return img;
	}
	
	private static class GameDataTask extends Task<Void> {

		@Override
		protected Void call() throws Exception {
			
			final ExcelParser parser = new ExcelParser();
			parser.parseFile(DATA_FILE_PATH);
			
			parser.loadHeroData(heroes);
			
			parser.loadCityData(cities);
			
			parser.loadForceData(forces);
			
			initialiseMap();
			
			populateCityHeroList();

			populateForceCityList();
			
			initialised = true;
			return null;
		}
		
		private static void initialiseMap() throws Exception {
			Thread.sleep(500);
			logger.info("Successfully created game map.");
		}
		
		private static void populateCityHeroList() {
			for (int i = 0; i < cities.size(); i++) {
				final City city = cities.get(i);
				for (int j = 0; j < heroes.size(); j++) {
					final Hero hero = heroes.get(j);
					if (city.getName().equals(hero.location))
						city.add(hero);
				}
			}
			logger.info("Heroes successfully added to cities");
		}
		
		private static void populateForceCityList() throws Exception {
			Thread.sleep(500);
			logger.info("Cities successfully added to forces");
		}
	}
}