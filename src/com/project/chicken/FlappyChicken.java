package com.project.chicken;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.project.objets.Pipe;

public class FlappyChicken implements Runnable{

	// VARIABLES
	private int width;
	private int height;
	private int x;
	private int y;
	private int dy;
	private String strImage;
	private ImageIcon iconchicken;
	private Image imgchicken;
	
	private final int PAUSE = 10;
	
	// CONSTRUCTEUR
	public FlappyChicken(int x, int y, String strImage){
		
		this.width = 34;
		this.height = 24;
		this.x = x;
		this.y = y;
		this.strImage = strImage;
		this.iconchicken = new ImageIcon(getClass().getResource(this.strImage));
		this.imgchicken = this.iconchicken.getImage();
		
		Thread Wing = new Thread(this);
		Wing.start();
	}

	
	// GETTERS
	public int getX() {return x;}
	
	public int getY() {return y;}
	
	public int getLargeur() {return width;}

	public int getHauteur() {return height;}

	public Image getImgOiseau() {return imgchicken;}
	
	
	// SETTERS
	public void setX(int x) {this.x = x;}

	public void setY(int y) {this.y = y;}
	
	
	// METHODES
	public void monte(){this.dy = 48;}

	private void batDesAiles(int dy){
		if(dy >10){
			this.iconchicken = new ImageIcon(getClass().getResource("/images/kiki2.png"));
			this.imgchicken = this.iconchicken.getImage();
			this.y = this.y - 3;
		}else if (dy > 5){this.y = this.y - 2;}
		else if (dy > 1){this.y = this.y - 1;}
		else if (dy == 1){
			this.iconchicken = new ImageIcon(getClass().getResource("/images/kiki1.png"));
			this.imgchicken = this.iconchicken.getImage();
		}
	}

	public boolean collision(Pipe tuyau){
		if(tuyau.getY() < 50){
			if(this.y <= tuyau.getY() + tuyau.getHeight() && this.x + this.width >= tuyau.getX() && 
					this.x <= tuyau.getX() + tuyau.getWidth()){return true;}
			else{return false;}
		}else
			if(this.y + this.height >= tuyau.getY() && this.x + this.width >= tuyau.getX() && 
			this.x <= tuyau.getX() + tuyau.getWidth()){return true;}
		     else{return false;}
	}

	
	@Override
	public void run() {
		while(true){
			this.batDesAiles(dy);
			this.dy--;
			try {Thread.sleep(PAUSE);} catch (InterruptedException e) {}
		}
		
	}
}