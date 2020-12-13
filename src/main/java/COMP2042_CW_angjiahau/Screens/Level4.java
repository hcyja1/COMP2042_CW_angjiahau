package COMP2042_CW_angjiahau.Screens;
import COMP2042_CW_angjiahau.Controllers.Level;
import COMP2042_CW_angjiahau.Models.Display.BackgroundImage;
import COMP2042_CW_angjiahau.Models.Display.Digit;
import COMP2042_CW_angjiahau.Controllers.HighScore;
import COMP2042_CW_angjiahau.Models.Platforms.Log;
import COMP2042_CW_angjiahau.Models.Obstacle;
import COMP2042_CW_angjiahau.Models.Platforms.Turtle;
import COMP2042_CW_angjiahau.Models.Platforms.WetTurtle;
import javafx.scene.control.Alert;

import java.io.IOException;


public class Level4 extends Level {

	public Level4()  {
		//add background image
		BackgroundImage froggerback = new BackgroundImage("level4background");
		add(froggerback);


		add(new Obstacle(100, (Rows.ROW1.getValue())+1, -5, 50, 50, "racecar"));
		add(new Obstacle(400, (Rows.ROW1.getValue())+1, -5, 50, 50, "racecar"));
		add(new Obstacle(0, (Rows.ROW2.getValue())+4, 5, 50, 50, "racecar"));
		add(new Obstacle(300, (Rows.ROW2.getValue())+4, 5, 50, 50, "racecar"));
		add(new Obstacle(600, (Rows.ROW2.getValue())+4, 5, 50, 50, "racecar"));
		add(new Obstacle(0, (Rows.ROW3.getValue())+4, 6, 50, 50, "racecar"));
		add(new Obstacle(500, (Rows.ROW3.getValue())+4, 6,50, 50, "racecar"));
		add(new Log(150, 0, (Rows.ROW5.getValue())+5, 0.75,3) );
		add(new Log(150, 220, (Rows.ROW5.getValue())+5, 0.75,3) );
		add(new Log(150, 440, (Rows.ROW5.getValue())+5, 0.74,3) );
		add(new Turtle(500, Rows.ROW6.getValue(), -1, 130, 130));
		add(new Turtle(300,  Rows.ROW6.getValue(), -1, 130, 130));
		add(new WetTurtle(700, (Rows.ROW8.getValue())-5, -1, 130, 130));
		add(new WetTurtle(350, (Rows.ROW8.getValue())-5, -1, 130, 130));
		add(new Log(300, 0,  Rows.ROW7.getValue(), -2,1) );
		add(new Log(300, 400,  Rows.ROW7.getValue(), -2,1) );
		add(new Log(150, 50, (Rows.ROW9.getValue())+5, 0.75,3) );
		add(new Log(150, 270, (Rows.ROW9.getValue())+5, 0.75,3) );
		add(new Log(150, 490, (Rows.ROW9.getValue())+5, 0.75,3) );
		add(new WetTurtle(300, (Rows.ROW10.getValue())-4, -1, 130, 130));
		add(new WetTurtle(600, (Rows.ROW10.getValue())-4, -1, 130, 130));
		add(new Turtle(300, (Rows.ROW10.getValue())-4, -1, 130, 130));


		getAnimal().toFront();
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
			highScoreCaller();
		}
				
	}
	
	@Override
	public void start() {
		super.start();
		getAnimal().reset();
	}
	       
	
	        
}
