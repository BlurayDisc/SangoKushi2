package com.run.sango.view.start;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.run.sango.controller.StartController;
import java.awt.Dimension;

public class StartFrame extends JFrame {

	private static final long serialVersionUID = -4030714380663582513L;
	private final StartController controller;

	public StartFrame(StartController inController) {
		
		setBackground(Color.WHITE);
		setMinimumSize(new Dimension(275, 535));
		
		controller = inController;
		
		setTitle("Sangokushi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		initComponents();
	}
	
	private void initComponents() {

		Container contentPane = getContentPane();
		contentPane.setLayout(new CardLayout(0, 0));
		
		StartPanel startPanel = new StartPanel(controller);
		contentPane.add(startPanel, "Start");
		
		NewGamePanel newPanel = new NewGamePanel(controller);
		contentPane.add(newPanel, "New Game");
		
		LoadGamePanel loadPanel = new LoadGamePanel(controller);
		contentPane.add(loadPanel, "Load Game");
		
		for (final JPanel panel: new JPanel[] {startPanel, newPanel, loadPanel}) {
			panel.setBorder(null);
			panel.setBackground(Color.WHITE);
		}
	}
}