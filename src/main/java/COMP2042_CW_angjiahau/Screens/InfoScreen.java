package COMP2042_CW_angjiahau.Screens;
import COMP2042_CW_angjiahau.Models.Display.BackgroundImage;
import COMP2042_CW_angjiahau.Models.Display.Buttons;
import COMP2042_CW_angjiahau.Controllers.World;

public class InfoScreen extends World {

	/** Reference variable used to create the start game button*/
	Buttons startLabel;
	/** Reference variable used to create the go back button*/
	Buttons backButton;
	/** Boolean variable used to determine if go back button is triggered*/
	Boolean goBack=false;

	/**
	 * When called and added to stage controller, this method shows the info screen.
	 * This method consists of a background image which displays the information and details to play the game,
	 * and 2 buttons which enable to user to either start game or go back to the main menu.
	 */
	public InfoScreen() {
		BackgroundImage froggerback = new BackgroundImage("InfoScreen");
		add(froggerback);
		startLabel = new Buttons("START Label",430,770,150,150);
		add(startLabel);
		backButton = new Buttons("BACKButton",15,7,150,150);
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

	/**
	 * Overriden method which is called in every frame as long as AnimationTimer is active.
	 * This Overriden method gives the "start game" button a blinking effect by alternating the visibility.
	 * @param now is the Timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
	 */
	@Override
	public void act(long now) {
		if (now/900000000  % 2 ==0) {
			startLabel.setVisible(false);
		}
		else if (now/900000000 % 2 == 1) {
			startLabel.setVisible(true);
		}
	}

	/**
	 *   It is used as a getter method to see if boolean goBack is true or false.
	 * 	 This method is called in {@link COMP2042_CW_angjiahau.Main} class within the act method
	 * 	 to check for the status of "goBack" variable. If it is, then the stage controller will set starting screen
	 * 	 as the root node and the window will go back to the starting screen.
	 * @return  Returns the value of boolean "goBack".
	 */
	public Boolean goBack() {
		return goBack;
	}

	/**
	 * This method is called in the InfoScreen() method as a way to set goBack to true,
	 * and is triggered when user clicks on the "Go Back" button.
	 * @return Boolean value "goBack" = true.
	 */
	public Boolean SetGoBack() {
		return goBack = true;
	}

	/**
	 * This method is used to reset the boolean value of goBack
	 * otherwise the user will only be able to use the goBack button once.
	 * @return boolean goBack = false.
	 */
	public Boolean resetGoBack() {
		return goBack = false;
	}


}