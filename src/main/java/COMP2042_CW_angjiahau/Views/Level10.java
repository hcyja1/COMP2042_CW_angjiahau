package COMP2042_CW_angjiahau.Views;
import COMP2042_CW_angjiahau.Controllers.Animal;
import COMP2042_CW_angjiahau.Controllers.Level;
import COMP2042_CW_angjiahau.Models.*;
import COMP2042_CW_angjiahau.Controllers.HighScore;
import javafx.scene.control.Alert;

import java.io.IOException;


public class Level10 extends Level {
    Animal animal;

    public Level10()  {
        //add background image
        BackgroundImage froggerback = new BackgroundImage("level10background");
        add(froggerback);


        //add obstacles
        add(new Obstacle(100, 640, -5, 50, 50, "racecar"));
        add(new Obstacle(400, 640, -5, 50, 50, "racecar"));
        add(new Obstacle(0, 593, 2, 50, 50, "pinkcar"));
        add(new Obstacle(300, 593, 2, 50, 50, "pinkcar"));
        add(new Obstacle(0, 544, 6, 50, 50, "racecar"));
        add(new Obstacle(500, 544, 6,50, 50, "racecar"));
        add(new Obstacle(600, 496, 3, 120, 120, "bigTruck"));
        add(new Obstacle(0, 448, 2, 200, 200, "longTruck"));
        add(new Obstacle(500, 448, 2, 200, 200, "longTruck"));
        add(new Obstacle(100, 385, -3, 50, 50, "racecar"));
        add(new Obstacle(400, 385, -3, 50, 50, "racecar"));
        add(new Obstacle(500, 355, -5, 50, 50, "car"));
        add(new Obstacle(100, 355, -5, 50, 50, "car"));
        add(new Obstacle(600, 315, 2, 120, 120, "bigTruck"));
        add(new Obstacle(600, 268, 5, 50, 50, "car"));
        add(new Obstacle(300, 268, 5, 50, 50, "car"));
        add(new Obstacle(0, 219, 1, 200, 200, "longTruck"));
        add(new Obstacle(500, 219, 1, 200, 200, "longTruck"));
        add(new Obstacle(400, 165, 4, 50, 50, "racecar"));
        add(new Obstacle(50, 165, 4, 50, 50, "racecar"));

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
            try {
                HighScore.HighScoreController("Level10", getAnimal().getPoints());
            } catch(IOException e) {
                e.printStackTrace();
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("CONGRATULATIONS! You Have Won!");
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