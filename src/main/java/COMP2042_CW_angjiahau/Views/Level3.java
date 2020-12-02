package COMP2042_CW_angjiahau.Views;
import COMP2042_CW_angjiahau.Controllers.Animal;
import COMP2042_CW_angjiahau.Controllers.Level;
import COMP2042_CW_angjiahau.Models.BackgroundImage;
import COMP2042_CW_angjiahau.Models.Digit;
import COMP2042_CW_angjiahau.Controllers.HighScore;
import COMP2042_CW_angjiahau.Models.Log;
import COMP2042_CW_angjiahau.Models.Obstacle;
import COMP2042_CW_angjiahau.Models.Turtle;
import COMP2042_CW_angjiahau.Models.WetTurtle;
import javafx.scene.control.Alert;

import java.io.IOException;


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

				//intialize starting main actor image 
				getAnimal().toFront();

				//add obstacles
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

				getAnimal().waterLevel(300);
				
				add(new Digit(0, 30, 550, 40));
				add(new HighScore("hi-scoreImage"));						
	}
	
	
	@Override
	public void act(long now) {
		if (getAnimal().changeScore()) {
			setNumber(getAnimal().getPoints());
		}
		if (getAnimal().getStop()) {
			stop();
			try {
				HighScore.HighScoreController("Level3", getAnimal().getPoints());
			} catch(IOException e) {
				e.printStackTrace();
			}
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("You Have Won The Round!");
			if(HighScore.checkHigher(getAnimal().getPoints())){
				alert.setHeaderText("You have a new High Score: "+getAnimal().getPoints()+"!");
			}else {
				alert.setHeaderText("Your High Score: " + getAnimal().getPoints() + "!");
			}
			alert.setContentText("Current Highscore List : " + HighScore.displayHighScore());
			alert.show();
		}
	}
	        
	@Override
	public void start() {
		super.start();
		getAnimal().reset();
	}
	
	     
	        
}
