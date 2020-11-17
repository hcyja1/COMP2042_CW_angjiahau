package COMP2042_CW_angjiahau.Views;

import COMP2042_CW_angjiahau.Models.BackgroundImage;
import COMP2042_CW_angjiahau.Models.Buttons;
import COMP2042_CW_angjiahau.Controllers.World;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class InfoScreen extends World {
	Buttons startLabel;
	Buttons backButton;
	Boolean goBack=false;
	Boolean startGame = false;

	public InfoScreen() {

		BackgroundImage froggerback = new BackgroundImage("InfoScreen");
		add(froggerback);
		startLabel = new Buttons("START Label",430,770,150,150);
		add(startLabel);
		backButton = new Buttons("BACKButton",15,10,150,150);
		add(backButton);

		backButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent event) {
				SetGoBack();
			}
		});

		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				switch(event.getCode()) {

					case ENTER:
						stop();
						break;

					case B:
						SetGoBack();
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

	public Boolean goBack() {
		return goBack;
	}

	public Boolean SetGoBack() {
		return goBack = true;
	}

	public Boolean resetGoBack() {
		return goBack = false;
	}


}