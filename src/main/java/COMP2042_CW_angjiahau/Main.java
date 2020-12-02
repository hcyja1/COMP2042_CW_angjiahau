package COMP2042_CW_angjiahau;

import java.util.Map;

import COMP2042_CW_angjiahau.Controllers.Animal;
import COMP2042_CW_angjiahau.Controllers.StageController;
import COMP2042_CW_angjiahau.Controllers.World;
import COMP2042_CW_angjiahau.Models.Music;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.Stage;
import COMP2042_CW_angjiahau.Views.*;

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
	Level6 level6;
	Level7 level7;
	Level8 level8;
	Level9 level9;
	Level10 level10;


	Scene scene;
	StageController stageController;
	World world;
	public static final String RESOURCE_PATH = "file:src/main/resources/";
	
	
	public static void main(String[] args) {
		launch(args);				
	}
		
	@Override
	public void start(Stage firstStage)  {
		//add existing levels
		startingScreen =  new StartingScreen();
		infoScreen = new InfoScreen();
		level1 = new Level1();
	    level2 = new Level2();	  
	    level3 = new Level3();
	    level4 = new Level4();
	    level5 = new Level5();
	    level6 = new Level6();
	    level7 = new Level7();
	    level8 = new Level8();
	    level9 = new Level9();
	    level10 = new Level10();

	    music = new Music();
	    
	    scene  = new Scene(startingScreen,600,800);
	    stageController = new StageController(12,scene);
	    
	   
	    stageController.addScreen("StartingScreen", startingScreen);	
	    stageController.addScreen("InfoScreen",infoScreen);        
	    stageController.addScreen("Level1", level1);
	    stageController.addScreen("Level2", level2);
	    stageController.addScreen("Level3", level3);	
	    stageController.addScreen("Level4", level4);
	    stageController.addScreen("Level5", level5);	
	    stageController.addScreen("Level6", level6);
	    stageController.addScreen("Level7", level7);
		stageController.addScreen("Level8", level8);
		stageController.addScreen("Level9",level9);
	    stageController.addScreen("Level10",level10);



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
  
   

