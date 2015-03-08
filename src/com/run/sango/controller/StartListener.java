package com.run.sango.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class StartListener implements ActionListener {
	
	public JFrame mainFrame;
	
	/** 
	 * Processes all the button clicks for the MainFrame 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		final JButton clickedButton = (JButton) e.getSource();
		
		if (clickedButton.getActionCommand().equals("Quit")) System.exit(0);
		
		CardLayout cardLayout = (CardLayout) mainFrame.getContentPane().getLayout();
		cardLayout.show(mainFrame.getContentPane(), clickedButton.getActionCommand());
	}

}