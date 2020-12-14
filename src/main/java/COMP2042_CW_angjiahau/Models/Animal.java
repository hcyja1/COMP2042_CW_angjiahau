package COMP2042_CW_angjiahau.Models;
import static COMP2042_CW_angjiahau.Main.RESOURCE_PATH;
import java.util.HashMap;
import COMP2042_CW_angjiahau.Controllers.Actor;
import COMP2042_CW_angjiahau.Controllers.End;
import COMP2042_CW_angjiahau.Controllers.Music;
import COMP2042_CW_angjiahau.Models.Platforms.Platform;
import COMP2042_CW_angjiahau.Models.Platforms.SinkingPlatform;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;


public class Animal extends Actor {
	/** Creates an object of Music. */
	Music music = new Music();
	/** String variable which stores file resource path for frog assets. */
	public static String FROG_RESOURCE_PATH = RESOURCE_PATH + "frog/";
	/** Integer variable which stores game points.*/
	int points = 0;
	/** Integer variable which stores number of frogs that has reached home.*/
	int end = 0;
	/** Boolean variable which keeps track of frogger movement. Determines if frogger sprite should jump or not.*/
	private boolean second = false;
	/** Boolean variable to determine if onkeyPressed event can be called. Used to allow or disallow movement*/
	boolean noMove = true;
	/** Double variable to set vertical movement of frogger */
	double movement = 13.3333333*2;
	/** Double variable to set horizontal movement of frogger*/
	double movementX = 10.666666*2;
	/**Private final integer variable to set the image size of frogger charcter. */
	private final int imgSize = 40;
	/** Boolean variable which keeps track if frogger has been killed by car.*/
	boolean carDeath = false;
	/** Boolean variable which keeps track if frogger has been killed by water.*/
	boolean waterDeath = false;
	/** Boolean variable used to determine if score can be changed.*/
	boolean changeScore = false;
	/** Double variable used to determine if frogger has already moved a certain y distance.*/
	double yMoved = 800;
	/** Double variable to determine water level within levels*/
	double waterLevel = 0;
	/** HashMap used to store images of carDeath animation*/
	HashMap<String,Image> carDeathAnimation = new HashMap<>();
	/** HashMap used to store images of waterDeath animation*/
	HashMap<String,Image> waterDeathAnimation = new HashMap<>();
	/** Timeline variable for carDeath animation*/
	Timeline carDeathT;
	/** Timeline variable for waterDeath animation*/
	Timeline waterDeathT;

	/**
	 *Method takes in a String variable which is the name of the character image file name within resource path for frog asset.
	 * Starts off by setting initial position and adding animation images to the hash maps
	 * Character controls are set within this method and based on {@link #setOnKeyPressed(EventHandler)} and {@link #setOnKeyReleased(EventHandler)}.
	 * Key released listener carries out the same actions as key pressed.
	 * @param animalImage Initializes Frogger Main Character Image.
	 */
	public Animal(String animalImage) {
		setImage(new Image(FROG_RESOURCE_PATH + animalImage + ".png", imgSize, imgSize, true, true));
		Image froggerNoJump = new Image(FROG_RESOURCE_PATH + "froggerUp.png", imgSize, imgSize, true, true);
		Image froggerJump = new Image(FROG_RESOURCE_PATH + "froggerUpJump.png", imgSize, imgSize, true, true);

		startingPosition();
		addHashCar();
		addHashWater();

		setOnKeyPressed(event-> {
			if (noMove) {
			}

			else{
				music.hopSound();
					if(event.getEventType() == KeyEvent.KEY_RELEASED){
						second = true;
					}
					switch (event.getCode()) {
						case UP:
						case W:
							move(0, -movement);
							setImage(second ? froggerNoJump : froggerJump);
							if ((getY() < yMoved) && (event.getEventType() == KeyEvent.KEY_RELEASED)) {
								changeScore = true;
								yMoved = getY();
								points += 10;
							}
							setRotate(0);
							break;

						case LEFT:
						case A:
								move(-movementX, 0);
								changeScore = false;
								setImage(second ? froggerNoJump : froggerJump);
								setRotate(-90);
								break;


						case DOWN:
						case S:
								move(0, movement);
								changeScore = false;
								setImage(second ? froggerNoJump : froggerJump);
								setRotate(-180);

							break;

						case RIGHT:
						case D:
								move(movementX, 0);
								changeScore = false;
								setImage(second ? froggerNoJump : froggerJump);
								setRotate(90);
							break;

						default:
							break;
					}
				second =!second;
				}
		});
		setOnKeyReleased(getOnKeyPressed());
	}

	/**
	 * Overriden method which is called in every frame as long as AnimationTimer is active.
	 * Overriden method constantly checks for {@link #checkoutOfBounds()}, {@link #collisionCheck()}, {@link #checkCarDeath()}, {@link #checkWaterDeath()} methods.
	 * @param now is the Timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
	 */
	@Override
	public void act(long now) {
		checkoutOfBounds();
		collisionCheck();
		checkCarDeath();
		checkWaterDeath();
	}

	/**
	 * Checks if frogger has collided with any objects.
	 * Frogger will die and be reset if it has collided with obstacle. If frogger intersects with platform,
	 * this method will cause the frogger character to move at the same speed of the platform if isSunk is false.
	 * If isSunk if true and frogger is on top of the platform, frogger character will die from waterDeath.
	 * If frogger has reached the end(home) and there is already an existing frogger, the {@link #deathReset()} method will be called.
	 * Otherwise, the {@link #froggerReachesHome()} method will be called.
	 */
	public void collisionCheck(){

			if (getIntersectingObjects(Obstacle.class).size() >= 1) {
				carDeath = true;
			}

			if (getIntersectingObjects(Platform.class).size() >= 1 && !noMove ) {
					Platform currentPlatform = getIntersectingObjects(Platform.class).get(0);
					move(currentPlatform.getSpeed(), 0);
				if (currentPlatform instanceof SinkingPlatform && ((SinkingPlatform)currentPlatform).isSunk()) {
					waterDeath = true;
				}
			}

			else if (getIntersectingObjects(End.class).size() >= 1) {
				if (getIntersectingObjects(End.class).get(0).isActivated()) {
						music.squashSound();
						deathReset();
				}	else {
						froggerReachesHome();
				}
			}

			else if (getY()<waterLevel){
				waterDeath = true;
			}
	}

	/**
	 * Checks if frogger has collided with car.
	 * If carDeath is true, character will not be able to move, media sounds for squashed is called
	 * and {@link #carDeathAnimation()} is called.
	 */
	public void checkCarDeath(){
		if (carDeath) {
			noMove = true;
			music.squashSound();
			carDeathAnimation();
		}
	}

	/**
	 * Checks if frogger has died from water.
	 * If waterDeath is true, character will not be able to move, media sounds for plunk is called
	 * and {@link #waterDeathAnimation()} is called.
	 */
	public void checkWaterDeath(){
		if (waterDeath) {
			noMove = true;
			waterDeathAnimation();
			music.plunkSound();
		}
	}

	/**
	 * Carries out actions for when frogger character reaches end point(home).
	 * 50 Points are added, yMoved is reset, the end position is filled and frogger returns to starting position.
	 */
	public void froggerReachesHome(){
		points+=50;
		changeScore = true;
		yMoved = 800;
		getIntersectingObjects(End.class).get(0).setEnd();
		end++;
		startingPosition();
	}

	/**
	 * Plays the animation for when frogger dies from water.
	 * {@link #deathReset()} method is called at the last frame of the animation timeline.
	 */
	public void waterDeathAnimation(){
		if(waterDeathT == null) {
			waterDeathT = new Timeline(
					new KeyFrame(Duration.millis(0), new KeyValue(imageProperty(), waterDeathAnimation.get("waterDeathAnimation1"))),
					new KeyFrame(Duration.millis(250), new KeyValue(imageProperty(), waterDeathAnimation.get("waterDeathAnimation2"))),
					new KeyFrame(Duration.millis(500), new KeyValue(imageProperty(), waterDeathAnimation.get("waterDeathAnimation3"))),
					new KeyFrame(Duration.millis(750), new KeyValue(imageProperty(), waterDeathAnimation.get("waterDeathAnimation4"))),
					new KeyFrame(Duration.seconds(1), event-> deathReset(), new KeyValue(imageProperty(), null))
			);
		}
		waterDeathT.setCycleCount(1);
		waterDeathT.play();
	}


	/**
	 * Plays the animation for when frogger dies from being squashed by an obstacle.
	 * {@link #deathReset()} method is called at the last frame of the animation timeline.
	 */
	public void carDeathAnimation(){
		if(carDeathT == null) {
			carDeathT = new Timeline(
					new KeyFrame(Duration.millis(0), new KeyValue(imageProperty(), carDeathAnimation.get("carDeathAnimation1"))),
					new KeyFrame(Duration.millis(250), new KeyValue(imageProperty(), carDeathAnimation.get("carDeathAnimation2"))),
					new KeyFrame(Duration.millis(500), new KeyValue(imageProperty(), carDeathAnimation.get("carDeathAnimation3"))),
					new KeyFrame(Duration.millis(750), new KeyValue(imageProperty(), carDeathAnimation.get("carDeathAnimation4"))),
					new KeyFrame(Duration.seconds(1), event-> deathReset() ,new KeyValue(imageProperty(), null))
			);
		}
		carDeathT.setCycleCount(1);
		carDeathT.play();
	}

	/**
	 * Adds animation images of car death into the hash map which is called in {@link #carDeathAnimation()}.
	 * Images are fetched from death animation file resource path.
	 */
	public void addHashCar(){
		for(int carDImages=0;carDImages<=3;carDImages++) {
			carDeathAnimation.put("carDeathAnimation"+carDImages, new Image(FROG_RESOURCE_PATH + "death_animations/cardeath" + carDImages + ".png", imgSize, imgSize, true, true));
		}
	}

	/**
	 * Adds animation images of car death into the hash map which is called in {@link #waterDeathAnimation()}.
	 * Images are fetched from death animation file resource path.
	 */
	public void addHashWater(){
		for(int waterDImages=0;waterDImages<=4;waterDImages++) {
			waterDeathAnimation.put("waterDeathAnimation"+waterDImages, new Image(FROG_RESOURCE_PATH + "death_animations/waterdeath" + waterDImages + ".png", imgSize, imgSize, true, true));
		}
	}

	/**
	 * Used in jUnit test to see if {@link #addHashWater()} has been carried out successfully, and if HashMap contains the images.
	 * @return HashMap of waterDeathAnimation.
	 */
	public HashMap<String,Image> checkWaterHash(){
		return waterDeathAnimation;
	}

	/**
	 * Used in jUnit test to see if {@link #addHashCar()} has been carried out successfully, and if HashMap contains the images.
	 * @return HashMap of carDeathAnimation.
	 */
	public HashMap<String,Image> checkCarHash(){
		return carDeathAnimation;
	}

	/**
	 * Method is called to reset character upon death.
	 * {@link #startingPosition()} is called, initial image of frogger is set, points are deducted by 50 if current points exceeds 50.
	 * boolean waterDeath and carDeath are reset.
	 */
	public void deathReset(){
		startingPosition();
		setImage(new Image(FROG_RESOURCE_PATH + "froggerUp.png", imgSize, imgSize, true, true));
		noMove = false;
		if (points > 50) {
			points -= 50;
			changeScore = true;
		}
		waterDeath = false;
		carDeath = false;
	}

	/**
	 * Checks to see if character has moved out of window.
	 */
	public void checkoutOfBounds(){
		if (getY()<0 || getY()>734) {
			startingPosition();
		}
		if (getX()<0) {
			move(movement*2, 0);
		}
		if (getX()>600) {
			move(-movement*2, 0);
		}
	}

	/**
	 * Sets character position to same initial position as when round starts.
	 */
	public void startingPosition(){
		setX(300);
		setY(679.8 + movement);
	}

	/**
	 * Setter method to set y-position of waterLevel for each round.
	 * @param waterLevel Height of water level. Any y-coordinate before this parameter will
	 * cause {@link #checkWaterDeath()} to be true and triggered if character is not on a platform that has isSunk() = false.
	 */
	public void waterLevel(int waterLevel) {
		this.waterLevel = waterLevel;
	}

	/**
	 * Sets the number of frogger to be brought home before the round ends.
	 * @return Number of frogs to be sent home before round ends.
	 */
	public boolean getStop() {
		return end==1;
	}

	/**
	 * Getter method for points.
	 * @return Value of points in the current round.
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Getter method which changes scoreboard to the current points.
	 * @return boolean value of changeScore.
	 */
	public boolean changeScore() {
		return changeScore;
	}

	/**
	 * Resets all elements for a fresh start each round.
	 * Similar to {@link #deathReset()}, but resets points and end back to 0. Method is called at the start of each level
	 * to ensure that each round is reset.
	 */
	public void reset() {
		deathReset();
		end = 0;
		points = 0;
	}
}
