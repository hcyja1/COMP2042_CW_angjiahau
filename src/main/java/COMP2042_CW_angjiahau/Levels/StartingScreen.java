package COMP2042_CW_angjiahau.Levels;

import javafx.application.Application;  
import javafx.scene.Scene;  
import javafx.scene.control.Button;  
import javafx.stage.Stage;  
import COMP2042_CW_angjiahau.BackgroundImage;
import COMP2042_CW_angjiahau.World;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public class StartingScreen extends World{
	Button startButton;
	Button infoButton;
	Button quitButton;
	
	public StartingScreen() {
	BackgroundImage froggerback = new BackgroundImage("MainScreen");
	add(froggerback);
	
	
	
	
	}

	

	@Override
	public void act(long now) {
			
	}
	

}
