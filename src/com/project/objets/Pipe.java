package com.project.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

public  class Pipe {

	// VARIABLES
	private int widht;
	private int height;
	private int x;
	private int y;
	private String strImage;
	private ImageIcon iconpipe;
	private Image imgpipe;
	 
	
	// CONSTRUCTEUR
	public Pipe(int x, int y, String strImage){
		this.widht = 50;
		this.height = 300;
		this.x = x;
		this.y = y;
		this.strImage = strImage;
		
		this.iconpipe = new ImageIcon(getClass().getResource(this.strImage));
		this.imgpipe = this.iconpipe.getImage();
	}


	// GETTERS
	public int getX() {return x;}

	public int getY() {return y;}

	public int getWidth() {return widht;}
	
	public int getHeight() {return height;}
	
	public Image getImgPipe() {return imgpipe;}
	
	
	// SETTERS
	public void setX(int x) {this.x = x;}

	public void setY(int y) {this.y = y;}
	
}