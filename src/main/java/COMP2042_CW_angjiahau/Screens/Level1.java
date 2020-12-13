package COMP2042_CW_angjiahau.Screens;
import COMP2042_CW_angjiahau.Controllers.*;
import COMP2042_CW_angjiahau.Models.*;
import COMP2042_CW_angjiahau.Models.Display.BackgroundImage;
import COMP2042_CW_angjiahau.Models.Display.Digit;
import COMP2042_CW_angjiahau.Models.Platforms.Log;
import COMP2042_CW_angjiahau.Models.Platforms.Turtle;
import COMP2042_CW_angjiahau.Models.Platforms.WetTurtle;
import javafx.scene.control.Alert;
import java.io.IOException;

public class Level1 extends Level {

	public Level1()  {

		//add background image
				BackgroundImage froggerback = new BackgroundImage("iKogsKW");
				add(froggerback);

				add(new Obstacle(0, Rows.ROW1.getValue(), 1, 120, 120, "bigTruck"));
				add(new Obstacle(300, Rows.ROW1.getValue(), 1, 120, 120, "bigTruck"));
				add(new Obstacle(600, Rows.ROW1.getValue(), 1, 120, 120, "bigTruck"));
				add(new Obstacle(100, Rows.ROW2.getValue(), -1, 50, 50, "car"));
				add(new Obstacle(250, Rows.ROW2.getValue(), -1, 50, 50, "car"));
				add(new Obstacle(400, Rows.ROW2.getValue(), -1, 50, 50, "car"));
				add(new Obstacle(550, Rows.ROW2.getValue(), -1, 50, 50, "car"));
				add(new Obstacle(0, Rows.ROW3.getValue(), 1, 200, 200, "longTruck"));
				add(new Obstacle(500, Rows.ROW3.getValue(), 1, 200, 200, "longTruck"));
				add(new Obstacle(500, Rows.ROW4.getValue(), -5, 50, 50, "car"));
				add(new Turtle(500, Rows.ROW6.getValue(), -1, 130, 130));
				add(new Turtle(300, Rows.ROW6.getValue(), -1, 130, 130));
				add(new WetTurtle(700, Rows.ROW6.getValue(), -1, 130, 130));
				add(new WetTurtle(600, Rows.ROW9.getValue(), -1, 130, 130));
				add(new WetTurtle(400, Rows.ROW9.getValue(), -1, 130, 130));
				add(new WetTurtle(200, Rows.ROW9.getValue(), -1, 130, 130));
				add(new Log(150, 0, Rows.ROW10.getValue(), 0.75,3) );
				add(new Log(150, 220, Rows.ROW10.getValue(), 0.75,3) );
				add(new Log(150, 440, Rows.ROW10.getValue(), 0.74,3) );
				add(new Log(300, 0, Rows.ROW8.getValue(), -2,1) );
				add(new Log(300, 400, Rows.ROW8.getValue(), -2,1) );
				add(new Log(150, 50, Rows.ROW7.getValue(), 0.75,3) );
				add(new Log(150, 270, Rows.ROW7.getValue(), 0.75,3) );
				add(new Log(150, 490, Rows.ROW7.getValue(), 0.75,3) );

				getAnimal().toFront();
				add(new Digit(0, 30, 550, 40));
				add(new HighScore("hi-scoreImage"));
				getAnimal().waterLevel(413);

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
