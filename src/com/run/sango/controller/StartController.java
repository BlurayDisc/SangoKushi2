package com.run.sango.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.run.sango.view.game.GameFrame;
import com.run.sango.view.start.StartFrame;

public class StartController {
	
	private static JFrame mainFrame;
	private static final StartListener listener = new StartListener();
	
	public static final ActionListener startGameListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			final GameController controller = new GameController();
			controller.setWorldSize(15, 10);
			final GameFrame frame = new GameFrame(controller);
			controller.addView(frame);
			frame.setVisible(true);
			mainFrame.dispose();
		}
	};
	
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