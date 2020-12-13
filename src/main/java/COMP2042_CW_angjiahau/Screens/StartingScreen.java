package COMP2042_CW_angjiahau.Screens;
import COMP2042_CW_angjiahau.Models.Display.BackgroundImage;
import COMP2042_CW_angjiahau.Models.Display.Buttons;
import COMP2042_CW_angjiahau.Controllers.World;



public class StartingScreen extends World{
	/** Boolean variable used to determine if start game button is triggered*/
	Boolean StartGame=false;
	/** Reference variable used to create the start game button*/
	Buttons startLabel;
	/** Reference variable used to create the info button*/
	Buttons infoButton;

	/**
	 * When called and added to stage controller, this method shows the starting screen.
	 * This method consists of a background image which shows the frogger chracter, game title, and
	 * and 2 buttons which enable to user to either start game or go to the info screen.
	 * If the info button is pressed, the stop() function will be called which triggers the next screen that is added
	 * within the StageController
	 */
	public StartingScreen() {

		BackgroundImage froggerback = new BackgroundImage("MainScreen");
		add(froggerback);

		startLabel = new Buttons("START Label",50,730,500,500);
		add(startLabel);

		infoButton = new Buttons("INFOButton",150,500,350,150);
		add(infoButton);

		infoButton.setOnMouseClicked(event-> stop());
		setOnKeyPressed(event-> {
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
	 *   It is used as a getter method to see if boolean StartGame is true or false.
	 * 	 This method is called in {@link COMP2042_CW_angjiahau.Main} class within the act method
	 * 	 to check for the status of the "StartGame" boolean variable. If it is, then the stage controller will set {@link Level1}
	 * 	 as the root node and the game will begin
	 * @return  Returns the value of boolean "StartGame".
	 */
	public Boolean startGame() {
		return StartGame;
	}

	/**
	 * This method is called in the StartingScreen() method as a way to set StartGame to true,
	 * and is triggered when user presses the "Enter" key on their keyboard.
	 * @return Boolean value "goBack" = true.
	 */
	public Boolean setStartGame() {
		return StartGame = true;
	}
	/**
	 * This method is used to reset the boolean value of StartGame
	 * @return boolean StartGame = false.
	 */
	public Boolean resetStartGame() {
		return StartGame = false;
	}

}