package com.run.sango.view.start;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.run.sango.controller.StartController;

public class LoadGamePanel extends JPanel {

	private static final long serialVersionUID = 815544009298504550L;

	/**
	 * Create the panel.
	 */
	public LoadGamePanel(StartController controller) {
		
		setSize(800, 600);
		
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[] {160, 160, 160, 160, 160};
		gbl.rowHeights = new int[] {120, 120, 120, 120, 120};
		gbl.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		setLayout(gbl);
		
		JLabel loadLb = new JLabel("Load Saved Game");
		loadLb.setFont(new Font("SansSerif", Font.PLAIN, 18));
		GridBagConstraints loadLbGbc = new GridBagConstraints();
		loadLbGbc.insets = new Insets(0, 0, 5, 5);
		loadLbGbc.gridx = 2;
		loadLbGbc.gridy = 0;
		add(loadLb, loadLbGbc);
		
		JButton backBtn = new JButton("Back");
		backBtn.setActionCommand("Start");
		backBtn.addActionListener(controller.getButtonListener());
		GridBagConstraints backBtnGbc = new GridBagConstraints();
		backBtnGbc.gridx = 4;
		backBtnGbc.gridy = 4;
		add(backBtn, backBtnGbc);
	}
}
