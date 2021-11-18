package com.project;

import javax.swing.JFrame;

public class Main {
	
	public static JFrame center;
	public static Scene scene;
	
	public static void main(String[] args) {
		
		center = new JFrame("Flappy Chicken");
		scene = new Scene();
		
		center.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		center.setSize(300, 425);
		center.setLocationRelativeTo(null);
		center.setResizable(false);
		center.setAlwaysOnTop(true);
		
		center.setContentPane(scene);
		center.setVisible(true);
	}

}
