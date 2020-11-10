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
import COMP2042_CW_angjiahau.Levels.Level1;

public class Main extends Application {
	AnimationTimer timer;
	Level1 level1;
	Animal animal;
	Music music;
	public static final String RESOURCE_PATH = "file:src/main/resources/";
	public static void main(String[] args) {
		launch(args);		
	
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
	   Level1 level1 = new Level1();	    
	    Scene scene  = new Scene(level1,600,800);
	   	    
	    //make window unresizable
	    primaryStage.setResizable(false);
				
		level1.start();
		primaryStage.setScene(scene);
		primaryStage.show();
		 
	}
	
	
    
   
}
