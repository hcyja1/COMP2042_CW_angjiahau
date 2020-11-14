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


public class Level5 extends Level {
	 Animal animal;
	 
	public Level5()  {
		//add background image
				BackgroundImage froggerback = new BackgroundImage("level5background");
				add(froggerback);
				
				
				//Add platforms	
				add(new Log(150, 0, 440, 0.75,3) );		
				add(new Log(150, 220, 440, 0.75,3) );
				add(new Log(150, 440, 440, 0.74,3) );
				add(new Turtle(500, 376, -1, 130, 130));
				add(new Turtle(300, 376, -1, 130, 130));
				add(new Log(300, 0, 329, -2,1) );
				add(new Log(300, 400, 329, -2,1) );
				add(new WetTurtle(700, 271, -1, 130, 130));
				add(new WetTurtle(350, 271, -1, 130, 130));				
				add(new Log(150, 50, 222, 0.75,3) );
				add(new Log(150, 270, 222, 0.75,3) );
				add(new Log(150, 490, 222, 0.75,3) );	
				add(new WetTurtle(300, 162, -1, 130, 130));
				add(new WetTurtle(600, 162, -1, 130, 130));
				add(new Turtle(300, 162, -1, 130, 130));
				
								
				//set 5 slots for frog to be filled in 
				add(new End(13,96));
				add(new End(141,96));
				add(new End(141 + 141-13,96));
				add(new End(141 + 141-13+141-13+1,96));
				add(new End(141 + 141-13+141-13+141-13+3,96));
				
				//intialize starting main actor image 
				animal = new Animal("froggerUp");						
				add(animal);
						
				//add obstacles
				add(new Obstacle(100, 640, -3, 50, 50, "racecar"));
				add(new Obstacle(400, 640, -3, 50, 50, "racecar"));
				add(new Obstacle(0, 593, 1, 120, 120, "bigTruck"));
				add(new Obstacle(300, 593, 1, 120, 120, "bigTruck"));
				add(new Obstacle(600, 593, 1, 120, 120, "bigTruck"));
				add(new Obstacle(0, 544, 2, 200, 200, "longTruck"));
				add(new Obstacle(500, 544, 2, 200, 200, "longTruck"));
				
				
				
				
			
				//define water death level
				animal.waterLevel(477);
				
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