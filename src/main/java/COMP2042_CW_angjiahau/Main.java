package COMP2042_CW_angjiahau;

import java.io.File;

import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import COMP2042_CW_angjiahau.Levels.Level;

public class Main extends Application {
	AnimationTimer timer;
	Level background;
	Animal animal;
	Music music;
	public static final String RESOURCE_PATH = "file:src/main/resources/";
	public static void main(String[] args) {
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
	    background = new Level();
	    music = new Music();
	    Scene scene  = new Scene(background,600,800);
	    
	    
	    //make window unresizable
	    primaryStage.setResizable(false);
		
	    //add background image
		BackgroundImage froggerback = new BackgroundImage("iKogsKW");
		background.add(froggerback);
		
		
		
		//Add platforms	
		background.add(new Log(150, 0, 166, 0.75,3) );		
		background.add(new Log(150, 220, 166, 0.75,3) );
		background.add(new Log(150, 440, 166, 0.74,3) );
		background.add(new Log(150, 0, 276, -2,1) );
		background.add(new Log(300, 400, 276, -2,1) );
		background.add(new Log(150, 50, 329, 0.75,3) );
		background.add(new Log(150, 270, 329, 0.75,3) );
		background.add(new Log(150, 490, 329, 0.75,3) );	
		
		background.add(new Turtle(500, 376, -1, 130, 130));
		background.add(new Turtle(300, 376, -1, 130, 130));
		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));
		
		//set 5 slots for frog to be filled in 
		background.add(new End(13,96));
		background.add(new End(141,96));
		background.add(new End(141 + 141-13,96));
		background.add(new End(141 + 141-13+141-13+1,96));
		background.add(new End(141 + 141-13+141-13+141-13+3,96));
		
		//intialize starting main actor image 
				animal = new Animal("froggerUp");
				background.add(animal);
				
		//add obstacles
		background.add(new Obstacle(0, 649, 1, 120, 120, "truck1Right"));
		background.add(new Obstacle(300, 649, 1, 120, 120, "truck1Right"));
		background.add(new Obstacle(600, 649, 1, 120, 120, "truck1Right"));
		background.add(new Obstacle(100, 597, -1, 50, 50, "car1Left"));
		background.add(new Obstacle(250, 597, -1, 50, 50, "car1Left"));
		background.add(new Obstacle(400, 597, -1, 50, 50, "car1Left"));
		background.add(new Obstacle(550, 597, -1, 50, 50, "car1Left"));
		background.add(new Obstacle(0, 540, 1, 200, 200, "truck2Right"));
		background.add(new Obstacle(500, 540, 1, 200, 200, "truck2Right"));
		background.add(new Obstacle(500, 490, -5, 50, 50, "car1Left"));
		
		
		background.add(new Digit(0, 30, 550, 25));
		background.start();
		primaryStage.setScene(scene);
		primaryStage.show();
		start();  
	}
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		music.stopMusic();
            		stop();
            		background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
            }
        };
    }
	public void start() {
		music.playMusic();
		
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 550 - shift, 25));
    		  shift+=30;
    		}
    }
}
