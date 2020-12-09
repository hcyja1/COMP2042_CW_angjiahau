package COMP2042_CW_angjiahau.Screens;
import COMP2042_CW_angjiahau.Controllers.*;
import COMP2042_CW_angjiahau.Models.*;
import javafx.scene.control.Alert;

import java.io.IOException;


public class Level9 extends Level {

    public Level9()  {
        //add background image
        BackgroundImage froggerback = new BackgroundImage("level9background");
        add(froggerback);

        add(new Obstacle(0, Rows.ROW1.getValue(), 4, 50, 50, "pinkcar"));
        add(new Obstacle(300, Rows.ROW1.getValue(), 4, 50, 50, "pinkcar"));
        add(new Obstacle(600, Rows.ROW1.getValue(), 4, 50, 50, "pinkcar"));
        add(new Obstacle(100, Rows.ROW2.getValue(), -5, 50, 50, "racecar"));
        add(new Obstacle(250,  Rows.ROW2.getValue(), -5, 50, 50, "racecar"));
        add(new Obstacle(400,  Rows.ROW2.getValue(), -5, 50, 50, "racecar"));
        add(new Obstacle(0,  Rows.ROW3.getValue(), 3, 200, 200, "longTruck"));
        add(new Obstacle(500,  Rows.ROW3.getValue(), 3, 200, 200, "longTruck"));
        add(new Obstacle(500,  Rows.ROW4.getValue(), -5, 50, 50, "car"));
        add(new Turtle(500, Rows.ROW6.getValue(), -3, 130, 130));
        add(new Turtle(300,  Rows.ROW6.getValue(), -3, 130, 130));
        add(new WetTurtle(700,  Rows.ROW6.getValue(), -3, 130, 130));
        add(new Log(150, 50, Rows.ROW7.getValue(), 2.50,3) );
        add(new Log(150, 270, Rows.ROW7.getValue(), 2.50,3) );
        add(new Log(150, 490, Rows.ROW7.getValue(), 2.50,3) );
        add(new Log(300, 0,  Rows.ROW8.getValue(), -3.5,1) );
        add(new Log(300, 400, Rows.ROW8.getValue(), -3.5,1) );
        add(new WetTurtle(600,  Rows.ROW9.getValue(), -2, 130, 130));
        add(new WetTurtle(400, Rows.ROW9.getValue(), -2, 130, 130));
        add(new WetTurtle(200, Rows.ROW9.getValue(), -2, 130, 130));
        add(new Log(150, 0, Rows.ROW10.getValue(), 2.50,3) );
        add(new Log(150, 220,  Rows.ROW10.getValue(), 2.50,3) );
        add(new Log(150, 440,  Rows.ROW10.getValue(), 2.50,3) );

        //intialize starting main actor image
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
            try {
                HighScore.HighScoreController("Level9", getAnimal().getPoints());
            } catch(IOException e){
                e.printStackTrace();
                System.out.println("Error in File Controller");
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