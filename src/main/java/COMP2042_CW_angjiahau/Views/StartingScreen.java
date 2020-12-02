package COMP2042_CW_angjiahau.Views;

import javafx.event.EventHandler;
import COMP2042_CW_angjiahau.Models.BackgroundImage;
import COMP2042_CW_angjiahau.Models.Buttons;
import COMP2042_CW_angjiahau.Controllers.World;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class StartingScreen extends World{
	Boolean StartGame=false;
	Buttons startLabel;
	Buttons infoButton;
	public StartingScreen() {

		BackgroundImage froggerback = new BackgroundImage("MainScreen");
		add(froggerback);
		startLabel = new Buttons("START Label",50,730,500,500);
		add(startLabel);
		infoButton = new Buttons("INFOButton",150,500,350,150);
		add(infoButton);

		infoButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent event) {
				stop();
			}
		});

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