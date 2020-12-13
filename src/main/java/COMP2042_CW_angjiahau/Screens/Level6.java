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



public class Level6 extends Level {

    public Level6()  {
        //add background image
        BackgroundImage froggerback = new BackgroundImage("level6background");
        add(froggerback);

        add(new Obstacle(0, Rows.ROW1.getValue(), 4, 50, 50, "pinkcar"));
        add(new Obstacle(300, Rows.ROW1.getValue(), 4, 50, 50, "pinkcar"));
        add(new Obstacle(550, Rows.ROW5.getValue(), -3, 200, 200, "longTruck"));
        add(new Obstacle(300, Rows.ROW5.getValue(), -3, 50, 50, "pinkcar"));
        add(new Obstacle(600, Rows.ROW1.getValue(), 3, 120, 120, "truck1"));
        add(new Obstacle(100, Rows.ROW2.getValue()-10, -3, 50, 50, "racecar"));
        add(new Obstacle(400, Rows.ROW2.getValue()-10, -3, 50, 50, "racecar"));
        add(new Obstacle(550, Rows.ROW2.getValue()-10, -3, 50, 50, "racecar"));
        add(new Obstacle(0, Rows.ROW3.getValue(), 3, 200, 200, "longTruck"));
        add(new Obstacle(500, Rows.ROW4.getValue()-10, 4, 50, 50, "pinkcar"));
        add(new Obstacle(100, Rows.ROW4.getValue()-10, 4, 50, 50, "pinkcar"));
        add(new Obstacle(400, Rows.ROW6.getValue()+4, 4, 50, 50, "pinkcar"));
        add(new Obstacle(50, Rows.ROW6.getValue()+4, 4, 50, 50, "pinkcar"));
        add(new Log(300, 0, Rows.ROW8.getValue(), -4,1) );
        add(new Log(300, 400, Rows.ROW8.getValue(), -4,1) );
        add(new Turtle(600, Rows.ROW9.getValue(), -3, 130, 130));
        add(new WetTurtle(400, Rows.ROW9.getValue(), -3, 130, 130));
        add(new WetTurtle(200, Rows.ROW9.getValue(), -3, 130, 130));
        add(new Log(150, 0, Rows.ROW10.getValue(), 3,3) );
        add(new Log(150, 220, Rows.ROW10.getValue(), 3,3) );
        add(new Log(150, 440, Rows.ROW10.getValue(), 3,3) );

        //intialize starting main actor image
        getAnimal().toFront();
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
            highScoreCaller();
        }
    }

    @Override
    public void start() {
        super.start();
        getAnimal().reset();
    }

}
