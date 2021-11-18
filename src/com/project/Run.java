package com.project;

public class Run implements Runnable{

	private final int PAUSE = 5;
	
	@Override
	public void run() {
		while(Main.scene.endGame == false){
			Main.scene.xBackground--;
			Main.scene.repaint();
			try {
				Thread.sleep(this.PAUSE);
			} catch (InterruptedException e) {}
		}	
	}
}
