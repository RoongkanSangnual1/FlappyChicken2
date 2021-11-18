package com.project;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel; 
import java.awt.Font;

import com.project.Time;
import com.project.chicken.FlappyChicken;
import com.project.objets.Pipe;

public class Scene extends JPanel{

	// VARIABLES
	private ImageIcon iconBackground;
	private Image imgbackground;
	
	public Pipe upperpipe1;
	public Pipe lowpipe1;
	public Pipe upperpipe2;
	public Pipe lowpipe2;
	public Pipe upperpipe3;
	public Pipe lowpipe3;
	

	
	
	
	public FlappyChicken flappyChicken;
	private int score;
	private Font police;
	private Time Time;
	
	
	private final int BACKGROUND_WIDTH = 140;
	private final int PIPE_DISTANCE = 250;
	private final int PIPE_GAP = 120;
	
	public int xBackground;
	private int xPipe;
	public boolean endGame;
	
	private Random Chance;
	
	
	// CONSTRUCTEUR
	public Scene(){
		
		super();
		this.iconBackground = new ImageIcon(getClass().getResource("/images/bbackground2.png"));
		this.imgbackground = this.iconBackground.getImage();
		
		this.xBackground = 0;
		this.xPipe = 400;
		this.endGame = false;
		
	
		
		this.upperpipe1 = new Pipe(this.xPipe, -150,"/images/upperpipe.png");
		this.lowpipe1 = new Pipe(this.xPipe, 250, "/images/lowpipe.png");
		this.upperpipe2 = new Pipe(this.xPipe + this.PIPE_DISTANCE, -100,"/images/upperpipe.png");
		this.lowpipe2 = new Pipe(this.xPipe + this.PIPE_DISTANCE, 300, "/images/lowpipe.png");
		this.upperpipe3 = new Pipe(this.xPipe + this.PIPE_DISTANCE * 2, -120,"/images/upperpipe.png");
		this.lowpipe3 = new Pipe(this.xPipe + this.PIPE_DISTANCE * 2, 280, "/images/lowpipe.png");
		
		this.flappyChicken = new FlappyChicken(100, 150,"/images/kiki3.png");
		
		Chance = new Random();
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Keyboard());
		Time = new Time();
		this.score = 0;
		this.police =new Font("Arial",Font.PLAIN,40);
		Thread RunScreen = new Thread(new Run());
		RunScreen.start();
	}

      
	 // METHODES
	
	private void deplacementbackground(Graphics g){
		if(this.xBackground == -this.BACKGROUND_WIDTH){this.xBackground = 0;}
		g.drawImage(this.imgbackground, this.xBackground, 0, null);
		g.drawImage(this.imgbackground, this.xBackground + this.BACKGROUND_WIDTH, 0, null);
		g.drawImage(this.imgbackground, this.xBackground + this.BACKGROUND_WIDTH * 2, 0, null);
		g.drawImage(this.imgbackground, this.xBackground + this.BACKGROUND_WIDTH * 3, 0, null);
	}
	
	private void deplacementPipe(Graphics g){
		// pipe1
	    this.upperpipe1.setX(this.upperpipe1.getX() - 1);
		this.lowpipe1.setX(this.upperpipe1.getX());
		
		if(this.upperpipe1.getX() == -100){
	    	this.upperpipe1.setX(this.upperpipe3.getX() + this.PIPE_DISTANCE);
	    	this.upperpipe1.setY(-100 - 10 * this.Chance.nextInt(18));
	    	this.lowpipe1.setY(this.upperpipe1.getY() + this.upperpipe1.getHeight() + this.PIPE_GAP);
	    }		
		g.drawImage(this.upperpipe1.getImgPipe(), this.upperpipe1.getX(), this.upperpipe1.getY(), null);
		g.drawImage(this.lowpipe1.getImgPipe(), this.lowpipe1.getX(), this.lowpipe1.getY(), null);
		
		// pipe2
		this.upperpipe2.setX(this.upperpipe2.getX() - 1);
		this.lowpipe2.setX(this.upperpipe2.getX());
		
		if(this.upperpipe2.getX() == -100){
			this.upperpipe2.setX(this.upperpipe1.getX() + this.PIPE_DISTANCE);
			this.upperpipe2.setY(-100 - 10 * this.Chance.nextInt(18));
	    	this.lowpipe2.setY(this.upperpipe2.getY() + this.upperpipe2.getHeight() + this.PIPE_GAP);
		}		
		g.drawImage(this.upperpipe2.getImgPipe(), this.upperpipe2.getX(), this.upperpipe2.getY(), null);
		g.drawImage(this.lowpipe2.getImgPipe(), this.lowpipe2.getX(), this.lowpipe2.getY(), null);
		
		// pipe3
		this.upperpipe3.setX(this.upperpipe3.getX() - 1);
		this.lowpipe3.setX(this.upperpipe3.getX());
		
		if(this.upperpipe3.getX() == -100){
			this.upperpipe3.setX(this.upperpipe2.getX() + this.PIPE_DISTANCE);
			this.upperpipe3.setY(-100 - 10 * this.Chance.nextInt(18));
	    	this.lowpipe3.setY(this.upperpipe3.getY() + this.upperpipe3.getHeight() + this.PIPE_GAP);
		}		
		g.drawImage(this.upperpipe3.getImgPipe(), this.upperpipe3.getX(), this.upperpipe3.getY(), null);
		g.drawImage(this.lowpipe3.getImgPipe(), this.lowpipe3.getX(), this.lowpipe3.getY(), null);	
	}
	
	private boolean collisionFlappy(){
        boolean endGame = false;
		// pipe1
		if(this.flappyChicken.getX() + this.flappyChicken.getLargeur() > this.lowpipe1.getX() - 20 && 
				this.flappyChicken.getX() < this.lowpipe1.getX() + this.lowpipe1.getWidth() + 20){
			endGame = this.flappyChicken.collision(this.lowpipe1);
			if(endGame == false){endGame = this.flappyChicken.collision(this.upperpipe1);}
		}else{
			// pipe2
			if(this.flappyChicken.getX() + this.flappyChicken.getLargeur() > this.lowpipe2.getX() - 20 && this.flappyChicken.getX() < this.lowpipe2.getX() + this.lowpipe2.getWidth() + 20){
				endGame = this.flappyChicken.collision(this.lowpipe2);
				if(endGame == false){endGame = this.flappyChicken.collision(this.upperpipe2);}			
		    }else{
				// pipe3
			    if(this.flappyChicken.getX() + this.flappyChicken.getLargeur() > this.lowpipe3.getX() - 20 && this.flappyChicken.getX() < this.lowpipe3.getX() + this.lowpipe3.getWidth() + 20){
			    	endGame = this.flappyChicken.collision(this.lowpipe3);
				    if(endGame == false){endGame = this.flappyChicken.collision(this.upperpipe3);}
			}else{
				// c
				if(this.flappyChicken.getY() < 0 || this.flappyChicken.getY() + this.flappyChicken.getHauteur() > 355){endGame = true;}else{endGame = false;}
		        }
		    }
	    }
		return endGame;
	}
    private void score() {
    	      if(this.lowpipe1.getX()+this.lowpipe1.getWidth()==95||this.lowpipe2.getX()+this.lowpipe2.getWidth()==95||this.lowpipe3.getX()+this.lowpipe3.getWidth()==95      ) {
    	this.score++;
    	      }
    }	
    


		
	
	private boolean Timeout(){
		if( this.Time.getCompteurTemps() <= 0){return true;}
		else{return false;}
	}
		
	public boolean Timeout2(){
		if(this.Timeout() == true){return true;}
		else{return false;}
	}
	public void paintComponent(Graphics g){
		this.deplacementbackground(g);
		this.deplacementPipe(g);
		    
		
		this.score();
		g.setFont(police);
		g.drawString(""+score,140,50);
		this.endGame = this.collisionFlappy();
		this.flappyChicken.setY(this.flappyChicken.getY() + 1);
		g.drawImage(this.flappyChicken.getImgOiseau(), this.flappyChicken.getX(), this.flappyChicken.getY(), null);
		g.drawString(this.Time.getStr(), 1, 380);
		
     {if(this.endGame==true) {g.drawString("Game Over",50,200);}
     if(this.Timeout2() == true){
	    	Font policeFin = new Font("Arial", Font.BOLD, 40);
         g.setFont(policeFin);
	        if(this.Timeout() == true){g.drawString("Time out",50,200);}
	        else{g.drawString("Time out",50,200);
	        }
	        }
}
	}
}


