package COMP2042_CW_angjiahau.Levels;
import COMP2042_CW_angjiahau.Actor;
import COMP2042_CW_angjiahau.Animal;
import COMP2042_CW_angjiahau.BackgroundImage;
import COMP2042_CW_angjiahau.Digit;
import COMP2042_CW_angjiahau.End;
import COMP2042_CW_angjiahau.HighScore;
import COMP2042_CW_angjiahau.Log;
import COMP2042_CW_angjiahau.Obstacle;
import COMP2042_CW_angjiahau.Turtle;
import COMP2042_CW_angjiahau.WetTurtle;
import COMP2042_CW_angjiahau.World;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.List;
import java.io.File;
import java.util.List;


public class Level3 extends Level {
	 Animal animal;
	 
	public Level3()  {
		//add background image
				BackgroundImage froggerback = new BackgroundImage("level3background");
				add(froggerback);
				
				
				//Add platforms	
				add(new Log(150, 0, 166, 0.75,3) );		
				add(new Log(150, 220, 166, 0.75,3) );
				add(new Log(150, 440, 166, 0.74,3) );
				add(new Log(300, 0, 276, -2,1) );
				add(new Log(300, 400, 276, -2,1) );
								
				add(new Turtle(600, 217, -2, 130, 130));
				add(new WetTurtle(400, 217, -2, 130, 130));
				add(new WetTurtle(200, 217, -2, 130, 130));
								
				//set 5 slots for frog to be filled in 
				add(new End(13,96));
				add(new End(141,96));
				add(new End(141 + 141-13,96));
				add(new End(141 + 141-13+141-13+1,96));
				add(new End(141 + 141-13+141-13+141-13+3,96));
				
				//intialize starting main actor image 
				animal = new Animal("froggerUp");						
				add(animal);
						
				add(new Obstacle(0, 649, 1, 120, 120, "bigTruck"));
				add(new Obstacle(300, 649, 1, 120, 120, "bigTruck"));				
				add(new Obstacle(550, 435, -2, 200, 200, "longTruck"));
				add(new Obstacle(300, 435, -2, 120, 120, "bigTruck"));
				add(new Obstacle(600, 649, 1, 120, 120, "truck1"));
				add(new Obstacle(100, 587, -3, 50, 50, "racecar"));
				add(new Obstacle(400, 587, -3, 50, 50, "racecar"));
				add(new Obstacle(550, 587, -3, 50, 50, "racecar"));
				add(new Obstacle(0, 540, 1, 200, 200, "longTruck"));
				add(new Obstacle(500, 540, 1, 200, 200, "longTruck"));
				add(new Obstacle(500, 480, 5, 50, 50, "racecar"));
				add(new Obstacle(100, 480, 5, 50, 50, "racecar"));
				add(new Obstacle(400, 380, 4, 50, 50, "racecar"));
				add(new Obstacle(50, 380, 4, 50, 50, "racecar"));
				
				animal.waterLevel(300);
				
				add(new Digit(0, 30, 550, 40));
				add(new HighScore("hi-scoreImage"));						
	}
	
	
	@Override
	public void act(long now) {
		
		
		
		if (animal.changeScore()) {
			setNumber(animal.getPoints());
		}
		if (animal.getStop()) {
			System.out.print("STOPP:");
			stop();
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("You Have Won The Game!");
			alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
			alert.setContentText("Highest Possible Score: 800");
			alert.show();
		}
		
		
	}
	        
	@Override
	public void start() {
		super.start();
		animal.reset();
	}
	
	     
	        
}
