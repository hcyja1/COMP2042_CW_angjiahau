package COMP2042_CW_angjiahau;

import java.io.File;
import java.util.List;
import COMP2042_CW_angjiahau.Animal;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import COMP2042_CW_angjiahau.Levels.*;

public class Main extends Application {
	Music music;
	AnimationTimer timer;
	MainLevel mainLevel;
	Level2 level2;
	Animal animal;
	Scene scene;
	StageController stageController;
	World world;
	public static final String RESOURCE_PATH = "file:src/main/resources/";
	
	
	public static void main(String[] args) {
		launch(args);				
	}
		
	@Override
	public void start(Stage firstStage) throws Exception {
		//add existing levels
	
		mainLevel = new MainLevel();
	    level2 = new Level2();	  
	    music = new Music();
	    scene  = new Scene(mainLevel,600,800);   
	    StageController stageController = new StageController(2,scene);	 
	    stageController.addScreen("MainLevel", mainLevel);		   
	    stageController.activate("MainLevel");	  
	    stageController.startScene();
	    
	    
	      
		 //make window unresizable & start
	    firstStage.setResizable(false);   
	    firstStage.setScene(scene);
	    firstStage.show();
	    start();
	    
		
	}
	
	
	public void createTimer() {
        timer = new AnimationTimer() {      
        	
         @Override            
          public void handle(long now) {     
        	if(scene.getRoot() == mainLevel && mainLevel.switchScene()) {
        		stageController.changeScene("Level2", level2);
        	}
            	 
            }
        };
    }
	
	
	public void start() {
		createTimer();
		timer.start();
		music.playMusic();
		
	}
	
	public void stop() {
		
		timer.stop();
	}
	
    
   
}
