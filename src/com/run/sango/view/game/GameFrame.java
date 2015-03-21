package com.run.sango.view.game;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import com.run.sango.controller.GameController;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 964135013642096286L;
	private final GameController controller;
	private final GamePanel contentPane;

	/** Create the frame. */
	public GameFrame(GameController controller) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, controller.frameWidth, controller.frameHeight);
		setResizable(false);
		
		this.controller = controller;
		this.contentPane = new GamePanel(this.controller);
		
		initComponents();
	}
	
	private void initComponents() {

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
}