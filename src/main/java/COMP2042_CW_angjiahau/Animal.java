package COMP2042_CW_angjiahau;
import static COMP2042_CW_angjiahau.Main.RESOURCE_PATH;

import java.util.ArrayList;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Animal extends Actor {
	Music music = new Music();
	public static String FROG_RESOURCE_PATH = RESOURCE_PATH + "frog/";
	int points = 0;
	int end = 0;
	private boolean second = false;
	boolean noMove = false;
	double movement = 13.3333333*2;
	double movementX = 10.666666*2;
	int imgSize = 40;
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean stop = false;
	boolean changeScore = false;
	int carD = 0;
	int waterD=0;
	double w = 800;
	
	
	ArrayList<End> inter = new ArrayList<End>(); 

	public Animal(String animalImage) {
		setImage(new Image(FROG_RESOURCE_PATH + animalImage + ".png", imgSize, imgSize, true, true));
		setX(300);
		setY(679.8+movement);
		
		
		Image imgW1 = new Image(FROG_RESOURCE_PATH + "froggerUp.png", imgSize, imgSize, true, true);
		Image imgA1 = new Image(FROG_RESOURCE_PATH + "froggerLeft.png", imgSize, imgSize, true, true);
		Image imgS1 = new Image(FROG_RESOURCE_PATH + "froggerDown.png", imgSize, imgSize, true, true);
		Image imgD1 = new Image(FROG_RESOURCE_PATH + "froggerRight.png", imgSize, imgSize, true, true);
		Image imgW2 = new Image(FROG_RESOURCE_PATH + "froggerUpJump.png", imgSize, imgSize, true, true);
		Image imgA2 = new Image(FROG_RESOURCE_PATH + "froggerLeftJump.png", imgSize, imgSize, true, true);
		Image imgS2 = new Image(FROG_RESOURCE_PATH + "froggerDownJump.png", imgSize, imgSize, true, true);
		Image imgD2 = new Image(FROG_RESOURCE_PATH + "froggerRightJump.png", imgSize, imgSize, true, true);
		
		
		
		setOnKeyPressed(new EventHandler<KeyEvent>() {
		
			public void handle(KeyEvent event){		
				
				if(noMove) {					
				} 			
				else {
					music.hopSound();
								
					switch(event.getCode()) {
						
					case UP:
					case W :						
							move(0, -movement);
							changeScore = false;
							setImage(second ? imgW1 : imgW2);
							break;
					case LEFT:		               					    
					case A :					
						move(-movementX, 0);
						changeScore = false;
						setImage(second ? imgA1 : imgA2);
						break;
						
					case DOWN:		           					
					case S : 					
						move(0, movement);
						changeScore = false;
						setImage(second ? imgS1 : imgS2);
						break;
					
					case RIGHT:
					case D : 				 	
						move(movementX, 0);
						changeScore = false;
						setImage(second ? imgD1 : imgD2);
						break;
						
					default:
						break;							
							}
					
					second = !second;
						}
					}
			});
			
	
	setOnKeyReleased(new EventHandler<KeyEvent>() {
		
		public void handle(KeyEvent event){		
			
			if(noMove) {					
			} 			
			else {
				music.hopSound();							
				switch(event.getCode()) {
				
				case UP:
				case W :					
					move(0, -movement);
	                setImage(imgW1);
	                second = false;	                
					if (getY() < w) {
						changeScore = true;
						w = getY();
						points+=10;
					}
					break;
	             
				case LEFT:
				case A :					
					 move(-movementX, 0);
	            	 setImage(imgA1);
	            	 second = false;
	            	 break;
				
				case DOWN:
				case S : 					
					move(0, movement);
	            	 setImage(imgS1);
	            	 second = false;
	            	 break;
				
				case RIGHT:
				case D : 				 	
					 move(movementX, 0);
	            	 setImage(imgD1);
	            	 second = false;
	            	 break;
					
				default:
						break;						
						}
					}
				}
		});	
}

	@Override
	public void act(long now) {
		int bounds = 0;
		if (getY()<0 || getY()>734) {
			setX(300);
			setY(679.8+movement);
		}
		if (getX()<0) {
			move(movement*2, 0);
		}
		
		
		
		if (carDeath) {
			music.squashSound();
			noMove = true;
			if ((now)% 11 ==0 || carD!=4) {
				carD++;
				setImage(new Image(FROG_RESOURCE_PATH + "death_animations/cardeath" +carD+ ".png", imgSize, imgSize, true, true));
			}
							
			if(carD==4) {
				setX(300);
				setY(679.8+movement);
				carDeath = false;
				carD = 0;
				setImage(new Image(FROG_RESOURCE_PATH + "froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}			
			}
		}
					
		if (waterDeath) {
			noMove = true;
			music.plunkSound();		
			
			if ((now)%11==0||carD!=5)  {												
				carD++;
				setImage(new Image(FROG_RESOURCE_PATH + "death_animations/waterdeath"+carD+".png", imgSize,imgSize , true, true));	
			}
					
							
			if(carD==5) {
				setX(300);
				setY(679.8+movement);
				waterDeath = false;
				carD = 0;
				setImage(new Image(FROG_RESOURCE_PATH + "froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
					if (points>50) {
							points-=50;
								changeScore = true;
							}
						}				
		}				
								
		
		if (getX()>600) {
			move(-movement*2, 0);
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getX() == 240 && getY() == 82) {
			stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=50;
			}
			points+=50;
			changeScore = true;
			w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setX(300);
			setY(679.8+movement);
		}
		else if (getY()<413){
			waterDeath = true;
			
		}
	}
	public boolean getStop() {
		return end==5;
	}
	
	public int getPoints() {
		return points;
	}
	
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	

}
