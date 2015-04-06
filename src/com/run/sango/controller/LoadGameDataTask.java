package com.run.sango.controller;

import com.run.sango.model.util.ExcelParser;

import javafx.concurrent.Task;

public class LoadGameDataTask extends Task<Void> {

	@Override
	protected Void call() throws Exception {
		
		final ExcelParser parser = new ExcelParser();
		parser.initDataSheets();
		parser.loadCharacterData();
		parser.loadCityData();
		
		return null;
	}
}
