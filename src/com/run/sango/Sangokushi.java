package com.run.sango;

import java.awt.EventQueue;

import com.run.sango.controller.StartController;
import com.run.sango.model.util.ExcelParser;
import com.run.sango.view.start.StartFrame;

public class Sangokushi {

	public static void main (String[] args) {
		
		setLookAndFeel();
		loadGameData();
		loadAndShowGUI();
	}
	
    public static void setLookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex){}
    }
    
    public static void loadAndShowGUI() {
    	
        EventQueue.invokeLater(new Runnable() {
        	@Override
            public void run() {
        		try {
        			final StartController controller = new StartController();
        			final StartFrame frame = new StartFrame(controller);
        			controller.addView(frame);
        			frame.setVisible(true);
				} catch (Exception e) {e.printStackTrace();}
            }
        });
    }
    
    public static void loadGameData() {
    	new Thread() {
    		@Override
    		public void run() {
	    		ExcelParser parser = new ExcelParser();
	    		parser.initDataSheets();
	    		parser.loadCharacterData();
	    		parser.loadCityData();
    		}
    	}.start();
    }
}