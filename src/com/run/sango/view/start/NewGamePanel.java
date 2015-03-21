package com.run.sango.view.start;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.run.sango.controller.StartController;

public class NewGamePanel extends JPanel {

	private static final long serialVersionUID = -3636055365496962413L;

	/**
	 * Create the panel.
	 */
	public NewGamePanel(StartController controller) {
		
		setSize(800, 600);
		
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[] {160, 160, 160, 160, 160};
		gbl.rowHeights = new int[] {120, 120, 120, 120, 120};
		gbl.columnWeights = new double[]{0.0, 0.0};
		gbl.rowWeights = new double[]{0.0, 0.0, 0.0};
		setLayout(gbl);
		
		JLabel newLb = new JLabel("Start New Game");
		newLb.setFont(new Font("SansSerif", Font.PLAIN, 18));
		GridBagConstraints newLabelGbc = new GridBagConstraints();
		newLabelGbc.insets = new Insets(0, 0, 5, 5);
		newLabelGbc.gridx = 2;
		newLabelGbc.gridy = 0;
		add(newLb, newLabelGbc);
		
		JButton startBtn = new JButton("Start Game");
		startBtn.setFont(new Font("SansSerif", Font.PLAIN, 18));
		startBtn.addActionListener(StartController.startGameListener);
		GridBagConstraints startBtnGbc = new GridBagConstraints();
		startBtnGbc.insets = new Insets(0, 0, 5, 5);
		startBtnGbc.gridx = 2;
		startBtnGbc.gridy = 1;
		add(startBtn, startBtnGbc);
		
		JButton backBtn = new JButton("Back");
		backBtn.setActionCommand("Start");
		backBtn.addActionListener(controller.getButtonListener());
		GridBagConstraints backBtnGbc = new GridBagConstraints();
		backBtnGbc.gridx = 4;
		backBtnGbc.gridy = 4;
		add(backBtn, backBtnGbc);
	}

}
