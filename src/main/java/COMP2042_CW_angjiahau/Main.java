package COMP2042_CW_angjiahau;
import java.util.Map;
import COMP2042_CW_angjiahau.Controllers.LevelGenerator;
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
	 * This methods adds Levels and Screens (In ascending order) to the stageController object called, then starts the game.
	 * 	 Method starts off by Assigning reference variables to their respective object Reference.
	 *  After that, stage controller will add levels from level generator.
	 * 	 The stage controller then activates the starting Screen for frogger game.
	 * 	 JavaFX Screen is then set to be unresizable and attemps to show the window by setting visibiliity to true
	 * 	  Lastly, start() method is called.
	 * @param startGame creates a new Instance of Stage
	 */
	@Override
	public void start(Stage startGame)  {
		startingScreen =  new StartingScreen();
		infoScreen = new InfoScreen();

	    music = new Music();
		scene  = new Scene(startingScreen,600,800);
		stageController = new StageController(12,scene);

	    stageController.addScreen("StartingScreen", startingScreen);	
	    stageController.addScreen("InfoScreen",infoScreen);        
	    stageController.addScreen("Level1", LevelGenerator.getLevel("Level1"));
	    stageController.addScreen("Level2", LevelGenerator.getLevel("Level2"));
	    stageController.addScreen("Level3", LevelGenerator.getLevel("Level3"));
	    stageController.addScreen("Level4", LevelGenerator.getLevel("Level4"));
	    stageController.addScreen("Level5", LevelGenerator.getLevel("Level5"));
	    stageController.addScreen("Level6", LevelGenerator.getLevel("Level6"));
	    stageController.addScreen("Level7", LevelGenerator.getLevel("Level7"));
		stageController.addScreen("Level8", LevelGenerator.getLevel("Level8"));
		stageController.addScreen("Level9", LevelGenerator.getLevel("Level9"));
	    stageController.addScreen("Level10", LevelGenerator.getLevel("Level10"));
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
					stageController.changeScene("Level1",LevelGenerator.getLevel("Level1"));
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
	 * This method creates and starts Animation Timer, causing it to start sending action events to its listeners and plays frogger music.
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
  
   

