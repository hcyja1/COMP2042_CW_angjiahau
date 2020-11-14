package COMP2042_CW_angjiahau.Levels;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;  
import javafx.scene.control.Button;  
import javafx.stage.Stage;  
import COMP2042_CW_angjiahau.BackgroundImage;
import COMP2042_CW_angjiahau.Buttons;
import COMP2042_CW_angjiahau.StageController;
import COMP2042_CW_angjiahau.Turtle;
import COMP2042_CW_angjiahau.World;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class StartingScreen extends World{
	Boolean StartGame=false;
	Buttons startLabel;

	public StartingScreen() {
		
	BackgroundImage froggerback = new BackgroundImage("MainScreen");
	add(froggerback);
	startLabel = new Buttons("START Label",50,730,500,500);
	add(startLabel);
	
   
	
	setOnKeyPressed(new EventHandler<KeyEvent>() {		
			public void handle(KeyEvent event){													
					switch(event.getCode()) {
					case I:
						stop();
						break;
					
					case ENTER:
						setStartGame();						
						break;
						
					default:
							break;
					}				
						}
					});		
	
			}
		
	@Override
	public void act(long now) {
			
		if (now/900000000  % 2 ==0) {
			startLabel.setVisible(false);						
		}
		else if (now/900000000 % 2 == 1) {
			startLabel.setVisible(true);			
		}		
		
		
	}
		
	 public Boolean startGame() {		
			return StartGame;	
		}
	
	 public Boolean setStartGame() {
			return StartGame = true;
		}
	 public Boolean resetStartGame() {		
			return StartGame = false;	
		}

}
