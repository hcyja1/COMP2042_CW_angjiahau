package COMP2042_CW_angjiahau.Screens;

import COMP2042_CW_angjiahau.Models.BackgroundImage;
import COMP2042_CW_angjiahau.Models.Buttons;
import COMP2042_CW_angjiahau.Controllers.World;



public class InfoScreen extends World {
	Buttons startLabel;
	Buttons backButton;
	Boolean goBack=false;


	public InfoScreen() {

		BackgroundImage froggerback = new BackgroundImage("InfoScreen");
		add(froggerback);
		startLabel = new Buttons("START Label",430,770,150,150);
		add(startLabel);
		backButton = new Buttons("BACKButton",15,10,150,150);
		add(backButton);

		backButton.setOnMouseClicked(event-> SetGoBack());

		setOnKeyPressed(event-> {
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