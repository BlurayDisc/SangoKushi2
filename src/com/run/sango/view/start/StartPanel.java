package com.run.sango.view.start;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.run.sango.controller.StartController;

public class StartPanel extends JPanel {

	private static final long serialVersionUID = 1862568131915209686L;

	/**
	 * Create the panel.
	 */
	public StartPanel(StartController controller) {
		
		setSize(800, 600);
		
		GridBagLayout gbl_startPanel = new GridBagLayout();
		gbl_startPanel.columnWidths = new int[] {233, 233, 233};
		gbl_startPanel.rowHeights = new int[] {50, 50, 100, 50, 100, 50, 100, 50};
		gbl_startPanel.columnWeights = new double[]{0.0, 0.0};
		gbl_startPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gbl_startPanel);
		
		JLabel lblSangokushi = new JLabel("Sangokushi");
		lblSangokushi.setFont(new Font("SansSerif", Font.PLAIN, 18));
		GridBagConstraints gbc_lblSangokushi = new GridBagConstraints();
		gbc_lblSangokushi.fill = GridBagConstraints.VERTICAL;
		gbc_lblSangokushi.insets = new Insets(0, 0, 5, 5);
		gbc_lblSangokushi.gridx = 1;
		gbc_lblSangokushi.gridy = 0;
		add(lblSangokushi, gbc_lblSangokushi);
		
		JButton loadButton = new JButton("Load Game");
		loadButton.setForeground(Color.WHITE);
		loadButton.setBackground(Color.BLACK);
		loadButton.addActionListener(controller.getButtonListener());
		
		JButton newButton = new JButton("New Game");
		newButton.setForeground(Color.WHITE);
		newButton.setBackground(Color.BLACK);
		newButton.addActionListener(controller.getButtonListener());
		
		JButton quitButton = new JButton("Quit");
		quitButton.setBackground(Color.BLACK);
		quitButton.setForeground(Color.WHITE);
		quitButton.addActionListener(controller.getButtonListener());
		
		GridBagConstraints newConstraints = new GridBagConstraints();
		newConstraints.fill = GridBagConstraints.BOTH;
		newConstraints.insets = new Insets(0, 0, 5, 5);
		newConstraints.gridx = 1;
		newConstraints.gridy = 2;
		add(newButton, newConstraints);
		
		GridBagConstraints loadConstraints = new GridBagConstraints();
		loadConstraints.fill = GridBagConstraints.BOTH;
		loadConstraints.insets = new Insets(0, 0, 5, 5);
		loadConstraints.gridx = 1;
		loadConstraints.gridy = 4;
		add(loadButton, loadConstraints);
		

		GridBagConstraints quitConstraints = new GridBagConstraints();
		quitConstraints.insets = new Insets(0, 0, 5, 5);
		quitConstraints.fill = GridBagConstraints.BOTH;
		quitConstraints.gridx = 1;
		quitConstraints.gridy = 6;
		add(quitButton, quitConstraints);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
