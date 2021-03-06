package COMP2042_CW_angjiahau.Screens;
import COMP2042_CW_angjiahau.Controllers.Level;
import COMP2042_CW_angjiahau.Models.Display.BackgroundImage;
import COMP2042_CW_angjiahau.Models.Platforms.Log;
import COMP2042_CW_angjiahau.Models.Obstacle;
import COMP2042_CW_angjiahau.Models.Platforms.Turtle;
import COMP2042_CW_angjiahau.Models.Platforms.WetTurtle;

public class Level3 extends Level {

	/**
	 * This constructor generates the third level of the game.
	 * Firstly, each level has its own background image which is added in the method.
	 * After that, the obstacles and platforms for each rows are added.
	 * The values for the y-coordinates of the rows are fetched from an enumeration at {@link Level}
	 * Main character is called to front so it does not get blocked by other variables
	 * Initial high score showing value of 0 and label is shown on top right corner
	 * Water Level is set.
	 */
	public Level3()  {
				BackgroundImage froggerback = new BackgroundImage("level3background");
				add(froggerback);

				add(new Obstacle(0, Rows.ROW1.getValue(), 1, 120, 120, "bigTruck"));
				add(new Obstacle(300, Rows.ROW1.getValue(), 1, 120, 120, "bigTruck"));
				add(new Obstacle(600, Rows.ROW1.getValue(), 1, 120, 120, "truck1"));
				add(new Obstacle(100, (Rows.ROW2.getValue())-10, -3, 50, 50, "racecar"));
				add(new Obstacle(400, (Rows.ROW2.getValue())-10, -3, 50, 50, "racecar"));
				add(new Obstacle(550, (Rows.ROW2.getValue())-10, -3, 50, 50, "racecar"));
				add(new Obstacle(0,  Rows.ROW3.getValue(), 1, 200, 200, "longTruck"));
				add(new Obstacle(500,  Rows.ROW3.getValue(), 1, 200, 200, "longTruck"));
				add(new Obstacle(500, (Rows.ROW4.getValue())-10, 5, 50, 50, "racecar"));
				add(new Obstacle(100, (Rows.ROW4.getValue())-10, 5, 50, 50, "racecar"));
				add(new Obstacle(550, Rows.ROW5.getValue(), -2, 200, 200, "longTruck"));
				add(new Obstacle(300, Rows.ROW5.getValue(), -2, 120, 120, "bigTruck"));
				add(new Obstacle(400, (Rows.ROW6.getValue())+4, 4, 50, 50, "racecar"));
				add(new Obstacle(50, (Rows.ROW6.getValue())+4, 4, 50, 50, "racecar"));
				add(new Log(300, 0, Rows.ROW8.getValue(), -2,1) );
				add(new Log(300, 400, Rows.ROW8.getValue(), -2,1) );
				add(new Turtle(600, Rows.ROW9.getValue(), -2, 130, 130));
				add(new WetTurtle(400, Rows.ROW9.getValue(), -2, 130, 130));
				add(new WetTurtle(200, Rows.ROW9.getValue(), -2, 130, 130));
				add(new Log(150, 0, Rows.ROW10.getValue(), 0.75,3) );
				add(new Log(150, 220, Rows.ROW10.getValue(), 0.75,3) );
				add(new Log(150, 440, Rows.ROW10.getValue(), 0.74,3) );

				getAnimal().toFront();
				getAnimal().waterLevel(300);
				showInitialHighScore();
	}

	/**
	 * Method which is called in every frame as long as AnimationTimer is active.
	 * Inherits the act() method from {@link Level}
	 * @param now is the Timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
	 */
	@Override
	public void act(long now) {
		super.act(now);
	}

	/**
	 * This method inherits the start() method from {@link Level}
	 */
	@Override
	public void start() {
		super.start();
	}
	
	     
	        
}
