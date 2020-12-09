package COMP2042_CW_angjiahau.Screens;
import COMP2042_CW_angjiahau.Controllers.Level;
import COMP2042_CW_angjiahau.Models.BackgroundImage;
import COMP2042_CW_angjiahau.Models.Digit;
import COMP2042_CW_angjiahau.Controllers.HighScore;
import COMP2042_CW_angjiahau.Models.Log;
import COMP2042_CW_angjiahau.Models.Turtle;
import COMP2042_CW_angjiahau.Models.WetTurtle;
import javafx.scene.control.Alert;

import java.io.IOException;


public class Level8 extends Level {


    public Level8()  {
        //add background image
        BackgroundImage froggerback = new BackgroundImage("level8background");
        add(froggerback);


        add(new WetTurtle(600, Rows.ROW1.getValue()-5, -2, 130, 130));
        add(new WetTurtle(100, Rows.ROW1.getValue()-5, -2, 130, 130));
        add(new Log(300, 0, Rows.ROW2.getValue(), -3,1) );
        add(new Log(300, 400, Rows.ROW2.getValue(), -3,1) );
        add(new Log(150, 600, Rows.ROW3.getValue(), 1.85,3) );
        add(new Log(150, 150, Rows.ROW3.getValue(), 1.85,3) );
        add(new Log(150, 410, Rows.ROW3.getValue(), 1.85,3) );
        add(new WetTurtle(250, Rows.ROW4.getValue(), -2, 130, 130));
        add(new WetTurtle(600, Rows.ROW4.getValue(), -2, 130, 130));
        add(new Log(150, 0, Rows.ROW5.getValue()+5, 1.85,3) );
        add(new Log(150, 220, Rows.ROW5.getValue()+5, 1.85,3) );
        add(new Log(150, 440, Rows.ROW5.getValue()+5, 1.85,3) );
        add(new Turtle(500, Rows.ROW6.getValue(), -3, 130, 130));
        add(new Turtle(300, Rows.ROW6.getValue(), -3, 130, 130));
        add(new Log(300, 0, Rows.ROW7.getValue(), -3,1) );
        add(new Log(300, 400, Rows.ROW7.getValue(), -3,1) );
        add(new WetTurtle(700, Rows.ROW8.getValue()-5, -2, 130, 130));
        add(new WetTurtle(350, Rows.ROW8.getValue()-5, -2, 130, 130));
        add(new Log(150, 50, Rows.ROW9.getValue()+5, 1.85,3) );
        add(new Log(150, 270, Rows.ROW9.getValue()+5, 1.85,3) );
        add(new Log(150, 490, Rows.ROW9.getValue()+5, 1.85,3) );
        add(new WetTurtle(300, Rows.ROW10.getValue()-4, -2, 130, 130));
        add(new WetTurtle(600, Rows.ROW10.getValue()-4, -3, 130, 130));
        add(new Turtle(300, Rows.ROW10.getValue()-4, -2, 130, 130));

        getAnimal().toFront();
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
                HighScore.HighScoreController("Level8",getAnimal().getPoints());
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