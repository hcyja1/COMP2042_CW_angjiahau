package COMP2042_CW_angjiahau.Views;
import COMP2042_CW_angjiahau.Controllers.Animal;
import COMP2042_CW_angjiahau.Controllers.Level;
import COMP2042_CW_angjiahau.Models.BackgroundImage;
import COMP2042_CW_angjiahau.Models.Digit;
import COMP2042_CW_angjiahau.Controllers.HighScore;
import COMP2042_CW_angjiahau.Models.Log;
import COMP2042_CW_angjiahau.Models.Turtle;
import COMP2042_CW_angjiahau.Models.WetTurtle;
import javafx.scene.control.Alert;

import java.io.IOException;


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
		add(new WetTurtle(600, 644, -1, 130, 130));
		add(new WetTurtle(100, 644, -1, 130, 130));
		add(new Log(300, 0, 597, -2,1) );
		add(new Log(300, 400, 597, -2,1) );
		add(new Log(150, 600, 540, 0.75,3) );
		add(new Log(150, 150, 540, 0.75,3) );
		add(new Log(150, 410, 540, 0.74,3) );
		add(new WetTurtle(250, 490, -1, 130, 130));
		add(new WetTurtle(600, 490, -1, 130, 130));

				
				//intialize starting main actor image 
				getAnimal().toFront();
						

				//define water death level
				getAnimal().waterLevel(680);
				
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
				HighScore.HighScoreController("Level5", getAnimal().getPoints());
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