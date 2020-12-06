package COMP2042_CW_angjiahau.Screens;
import COMP2042_CW_angjiahau.Models.Animal;
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


public class Level4 extends Level {
	 Animal animal;
	 
	public Level4()  {
		//add background image
				BackgroundImage froggerback = new BackgroundImage("level4background");
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
				

				
				//intialize starting main actor image 
				getAnimal().toFront();
						
				//add obstacles
				add(new Obstacle(100, 640, -5, 50, 50, "racecar"));
				add(new Obstacle(400, 640, -5, 50, 50, "racecar"));
				add(new Obstacle(0, 593, 5, 50, 50, "racecar"));
				add(new Obstacle(300, 593, 5, 50, 50, "racecar"));
				add(new Obstacle(600, 593, 5, 50, 50, "racecar"));
				add(new Obstacle(0, 544, 6, 50, 50, "racecar"));
				add(new Obstacle(500, 544, 6,50, 50, "racecar"));
				
											
				//define water death level
				getAnimal().waterLevel(477);
				
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
				HighScore.HighScoreController("Level4", getAnimal().getPoints());
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
