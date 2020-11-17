package COMP2042_CW_angjiahau;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import COMP2042_CW_angjiahau.Animal;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import COMP2042_CW_angjiahau.Levels.*;

public class Main extends Application {
	StartingScreen startingscreen;
	Music music;
	AnimationTimer timer;
	StartingScreen startingScreen;
	InfoScreen infoScreen;
	Level1 level1;
	Level2 level2;
	Level3 level3;
	Level4 level4;
	Level5 level5;
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
		startingScreen =  new StartingScreen();
		infoScreen = new InfoScreen();
		level1 = new Level1();
	    level2 = new Level2();	  
	    level3 = new Level3();
	    level4 = new Level4();
	    level5 = new Level5();
	    music = new Music();
	    
	    scene  = new Scene(level1,600,800);   
	    stageController = new StageController(6,scene);
	    
	   
	    stageController.addScreen("StartingScreen", startingScreen);	
	    stageController.addScreen("InfoScreen",infoScreen);        
	    stageController.addScreen("Level1", level1);	
	    stageController.addScreen("Level2", level2);
	    stageController.addScreen("Level3", level3);	
	    stageController.addScreen("Level4", level4);
	    stageController.addScreen("Level5", level5);	
	    
	    stageController.activate("StartingScreen");
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
        	 if (scene.getRoot() == startingScreen && startingScreen.startGame()) {
					stageController.changeScene("Level1",level1);
					startingScreen.resetStartGame();
				}
			 if (scene.getRoot() == infoScreen && infoScreen.goBack()) {
				 stageController.changeScene("StartingScreen",startingScreen);
				 infoScreen.resetGoBack();
			 }
			 for (Map.Entry<String, World> entry : stageController.getScreenMap().entrySet()) {
         		if (entry.getValue().switchScene()) {
         			entry.getValue().resetSwitchScene();
         			stageController.nextScene(entry.getKey());
				} 
         		
            		
    					
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
  
   

