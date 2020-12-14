package COMP2042_CW_angjiahau.Screens;
import COMP2042_CW_angjiahau.Controllers.Level;
import COMP2042_CW_angjiahau.Models.*;
import COMP2042_CW_angjiahau.Models.Display.BackgroundImage;


public class Level10 extends Level {

    /**
     * This method generates the last level of the game.
     * Firstly, each level has its own background image which is added in the method.
     * After that, the obstacles and platforms for each rows are added.
     * The values for the y-coordinates of the rows are fetched from an enumeration at {@link Level}
     * Main character is called to front so it does not get blocked by other variables
     * Initial high score showing value of 0 and label is shown on top right corner
     * Water Level is set.
     */
    public Level10()  {
        BackgroundImage froggerback = new BackgroundImage("level10background");
        add(froggerback);

        add(new Obstacle(100, Rows.ROW1.getValue()-9, -5, 50, 50, "racecar"));
        add(new Obstacle(400, Rows.ROW1.getValue()-9, -5, 50, 50, "racecar"));
        add(new Obstacle(0, Rows.ROW2.getValue()-4, 2, 50, 50, "pinkcar"));
        add(new Obstacle(300, Rows.ROW2.getValue()-4, 2, 50, 50, "pinkcar"));
        add(new Obstacle(0, Rows.ROW3.getValue()+4, 6, 50, 50, "racecar"));
        add(new Obstacle(500, Rows.ROW3.getValue()+4, 6,50, 50, "racecar"));
        add(new Obstacle(600, Rows.ROW4.getValue()+6, 3, 120, 120, "bigTruck"));
        add(new Obstacle(0, Rows.ROW5.getValue()+13, 2, 200, 200, "longTruck"));
        add(new Obstacle(500, Rows.ROW5.getValue()+13, 2, 200, 200, "longTruck"));
        add(new Obstacle(100, Rows.ROW6.getValue()+9, -3, 50, 50, "racecar"));
        add(new Obstacle(400, Rows.ROW6.getValue()+9, -3, 50, 50, "racecar"));
        add(new Obstacle(600, Rows.ROW7.getValue(), 3, 120, 120, "bigTruck"));
        add(new Obstacle(200, Rows.ROW7.getValue(), 3, 120, 120, "bigTruck"));
        add(new Obstacle(600, Rows.ROW8.getValue()-8, 5, 50, 50, "car"));
        add(new Obstacle(300, Rows.ROW8.getValue()-8, 5, 50, 50, "car"));
        add(new Obstacle(0, Rows.ROW9.getValue()+2, 1, 200, 200, "longTruck"));
        add(new Obstacle(500, Rows.ROW9.getValue()+2, 1, 200, 200, "longTruck"));
        add(new Obstacle(400, Rows.ROW10.getValue()-1, 4, 50, 50, "racecar"));
        add(new Obstacle(50, Rows.ROW10.getValue()-1, 4, 50, 50, "racecar"));

        getAnimal().toFront();
        getAnimal().waterLevel(0);
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