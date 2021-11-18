package  com.project;

public class Time implements Runnable{

	//**** VARIABLES ****//
	private final int PAUSE = 1000;	
	private int timer;
	private String str;
	
	
	//**** CONSTRUCTEUR ****//
	public Time(){
		this.timer = 30; 
		this.str = "time = 30";		
		Thread compteARebours = new Thread(this);
		compteARebours.start();
	}

	
	//**** GETTERS ****//	
	public int getCompteurTemps() {return timer;}
	
    public String getStr() {return str;}

	  
    //**** SETTERS ****//
    
    
    //**** METHODES ****//	
	@Override
	public void run() {				
		while(true){ //											
		    try{Thread.sleep(PAUSE);}
			catch (InterruptedException e){}
			this.timer--;
			this.str = "time : " + this.timer;
		}		
	} 	
}