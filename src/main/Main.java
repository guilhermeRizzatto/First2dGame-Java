package main;

import java.awt.Toolkit;

import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {

		System.setProperty("sun.java2d.opengl", "true");
		 
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("2D GAME");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.startGameThread();
		
	}

}
