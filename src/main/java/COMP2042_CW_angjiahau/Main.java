package COMP2042_CW_angjiahau;
import java.util.Map;
import COMP2042_CW_angjiahau.Controllers.StageController;
import COMP2042_CW_angjiahau.Controllers.World;
import COMP2042_CW_angjiahau.Controllers.Music;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.Stage;
import COMP2042_CW_angjiahau.Screens.*;


/**
 * Main Class of Frogger Game for Software Maintenance Coursework(COMP2042) 2020
 * @author Ang Jia Hau
 */

public class Main extends Application {
	/** Reference Variable declaration to access methods within Music Class */
	Music music;
	/** Variable declaration to access methods within {@link javafx.animation.AnimationTimer} package */
	AnimationTimer timer;
	/** Reference Variable declaration which calls StartingScreen Class, to be added into stageController */
	StartingScreen startingScreen;
	/** Reference Variable declaration which calls infoScreen Class, to be added into stageController */
	InfoScreen infoScreen;
	/** Reference Variable declaration which calls Level1 Class, to be added into stageController */
	Level1 level1;
	/** Reference Variable declaration which calls Level2 Class, to be added into stageController */
	Level2 level2;
	/** Reference Variable declaration which calls Level3 Class, to be added into stageController */
	Level3 level3;
	/** Reference Variable declaration which calls Level4 Class, to be added into stageController */
	Level4 level4;
	/** Reference Variable declaration which calls Level5 Class, to be added into stageController */
	Level5 level5;
	/** Reference Variable declaration which calls Level6 Class, to be added into stageController */
	Level6 level6;
	/** Reference Variable declaration which calls Level7 Class, to be added into stageController */
	Level7 level7;
	/** Reference Variable declaration which calls Level8 Class, to be added into stageController */
	Level8 level8;
	/** Reference Variable declaration which calls Level9 Class, to be added into stageController */
	Level9 level9;
	/** Reference Variable declaration which calls Level10 Class, to be added into stageController */
	Level10 level10;
	/** Reference Variable declaration to access methods within {@link javafx.scene} package */
	Scene scene;
	/** Reference Variable declaration to access methods within {@link StageController} package */
	StageController stageController;

	/** String variable declaration which has the main resources folder path assigned to it,
	 * it is set to public so other classes may access the file path */
	public static final String RESOURCE_PATH = "file:src/main/resources/";

	/**
	 * The main() method is ignored if JavaFX application is correctly deployed.
	 * This method is only used as a fallback method in the scenario that
	 * the javaFX application is unable to be launched through deployment artifacts.
	 * @param args the command line arguments - unused
	 */
	public static void main(String[] args) {
		launch(args);				
	}


	/**
	 * This methods adds Levels and Screens to the stageController object called, then starts the game.
	 * 	 Method starts off by Assigning reference variables to their respective object Reference.
	 * 	 After that, the stageController object will call the addScreen function which adds screens to be played and activated.
	 * 	 The stage controller then activates the starting Screen for frogger game.
	 * 	 JavaFX Screen is then set to be unresizable and attemps to show the window by setting visibiliity to true
	 * 	  Lastly, start() method is called.
	 * @param startGame creates a new Instance of Stage
	 */
	@Override
	public void start(Stage startGame)  {

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

	    startGame.setResizable(false);
	    startGame.setScene(scene);
	    startGame.show();
	    start();

	}

	/**
	 *Assigns previously declared reference variable "timer" to object Animation Timer.
	 */
	public void createTimer() {
        timer = new AnimationTimer() {

			/**
			 * Overriden method which is called in every frame as long as AnimationTimer is active.
			 * This Overriden method makes sure the scenes change according to user prompt and game stage.
			 * @param now is the Timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
			 */
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

	/**
	 * This method creates and starts Animation Timer, and plays frogger music.
	 */
	public void start() {
		createTimer();
		timer.start();
		music.playMusic();
	}

	/**
	 * This method stops Animation Timer frogger music.
	 */
	public void stop() {	
		timer.stop();
		music.stopMusic();
	}
	
    
   
}
  
   

