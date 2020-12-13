package COMP2042_CW_angjiahau.Screens;
import COMP2042_CW_angjiahau.Controllers.Level;
import COMP2042_CW_angjiahau.Models.*;
import COMP2042_CW_angjiahau.Controllers.HighScore;
import COMP2042_CW_angjiahau.Models.Display.BackgroundImage;
import COMP2042_CW_angjiahau.Models.Display.Digit;
import javafx.scene.control.Alert;

import java.io.IOException;


public class Level10 extends Level {


    public Level10()  {
        //add background image
        BackgroundImage froggerback = new BackgroundImage("level10background");
        add(froggerback);

        //add obstacles
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

        //intialize starting main actor image
        getAnimal().toFront();
        //define water death level
        getAnimal().waterLevel(0);
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