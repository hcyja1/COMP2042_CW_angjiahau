package COMP2042_CW_angjiahau.Levels;

import COMP2042_CW_angjiahau.BackgroundImage;
import COMP2042_CW_angjiahau.Buttons;
import COMP2042_CW_angjiahau.World;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;


public class InfoScreen extends World {
	Buttons startLabel;
	Boolean backHomeScreen=false;
	Boolean startGame = false;
	public InfoScreen() {	
	BackgroundImage froggerback = new BackgroundImage("InfoScreen");
	add(froggerback);
	startLabel = new Buttons("START Label",430,770,150,150);
	add(startLabel);
	
	setOnKeyPressed(new EventHandler<KeyEvent>() {		
		public void handle(KeyEvent event){													
				switch(event.getCode()) {
				case ENTER:
					stop();
					
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
	
	
	
}
