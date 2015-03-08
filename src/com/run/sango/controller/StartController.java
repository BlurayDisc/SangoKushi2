package com.run.sango.controller;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartController {
	
	private JFrame mainFrame;
	private final StartListener listener = new StartListener();
	
	public void addView(JFrame frame) {
		mainFrame = frame;
		listener.mainFrame = mainFrame;
	}
	
	public void addView(JPanel panel) {
		
	}
	
	public ActionListener getButtonListener() {
		return listener;
	}
}