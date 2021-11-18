package com.project;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Keyboard implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
	    if(e.getKeyCode() == KeyEvent.VK_SPACE){
	    	Main.scene.flappyChicken.monte();	    	
	    }
	}
	
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

}