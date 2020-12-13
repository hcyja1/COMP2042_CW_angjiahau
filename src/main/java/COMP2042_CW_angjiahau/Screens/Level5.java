package COMP2042_CW_angjiahau.Screens;
import COMP2042_CW_angjiahau.Controllers.Level;
import COMP2042_CW_angjiahau.Models.Display.BackgroundImage;
import COMP2042_CW_angjiahau.Models.Display.Digit;
import COMP2042_CW_angjiahau.Controllers.HighScore;
import COMP2042_CW_angjiahau.Models.Platforms.Log;
import COMP2042_CW_angjiahau.Models.Platforms.Turtle;
import COMP2042_CW_angjiahau.Models.Platforms.WetTurtle;
import javafx.scene.control.Alert;

import java.io.IOException;


public class Level5 extends Level {
	 
	public Level5()  {
		//add background image
				BackgroundImage froggerback = new BackgroundImage("level5background");
				add(froggerback);


				add(new WetTurtle(600, Rows.ROW1.getValue()-5, -1, 130, 130));
				add(new WetTurtle(100, Rows.ROW1.getValue()-5, -1, 130, 130));
				add(new Log(300, 0, Rows.ROW2.getValue(), -2,1) );
				add(new Log(300, 400, Rows.ROW2.getValue(), -2,1) );
				add(new Log(150, 600, Rows.ROW3.getValue(), 0.75,3) );
				add(new Log(150, 150, Rows.ROW3.getValue(), 0.75,3) );
				add(new Log(150, 410, Rows.ROW3.getValue(), 0.74,3) );
				add(new WetTurtle(250, Rows.ROW4.getValue()-4, -1, 130, 130));
				add(new WetTurtle(600, Rows.ROW4.getValue()-4, -1, 130, 130));
				add(new Log(150, 0,  Rows.ROW5.getValue()+5, 0.75,3) );
				add(new Log(150, 220, Rows.ROW5.getValue()+5, 0.75,3) );
				add(new Log(150, 440, Rows.ROW5.getValue()+5, 0.74,3) );
				add(new Turtle(500, Rows.ROW6.getValue(), -1, 130, 130));
				add(new Turtle(300, Rows.ROW6.getValue(), -1, 130, 130));
				add(new Log(300, 0, Rows.ROW7.getValue(), -2,1) );
				add(new Log(300, 400, Rows.ROW7.getValue(), -2,1) );
				add(new WetTurtle(700, Rows.ROW8.getValue()-5, -1, 130, 130));
				add(new WetTurtle(350, Rows.ROW8.getValue()-5, -1, 130, 130));
				add(new Log(150, 50, Rows.ROW9.getValue()+5, 0.75,3) );
				add(new Log(150, 270, Rows.ROW9.getValue()+5, 0.75,3) );
				add(new Log(150, 490, Rows.ROW9.getValue()+5, 0.75,3) );
				add(new WetTurtle(300, Rows.ROW10.getValue()-4, -1, 130, 130));
				add(new WetTurtle(600, Rows.ROW10.getValue()-4, -1, 130, 130));
				add(new Turtle(300, Rows.ROW10.getValue()-4, -1, 130, 130));


				
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
			highScoreCaller();
		}
	}
	        
	@Override
	public void start() {
		super.start();
		getAnimal().reset();
	}
	
	     
	        
}