package COMP2042_CW_angjiahau.Models.Platforms;
import javafx.animation.*;
import javafx.scene.image.*;
import javafx.util.Duration;
import java.util.HashMap;
import static COMP2042_CW_angjiahau.Main.RESOURCE_PATH;

public class Turtle extends Platform {
	/** String variable which holds the resource path for platform files*/
	public static final String PLATFORM_RESOURCE_PATH = RESOURCE_PATH + "/platforms/";
	/** Hash Map which stores animation for turtle*/
	HashMap<String,Image> TurtleAnimation = new HashMap<>();
	/** Timeline variable for turtle movement animation*/
	Timeline timeline = new Timeline();

	/**
	 * Overriden method which is called in every frame as long as AnimationTimer is active.
	 * This Overriden method makes sure the Turtle object generated is always moving and always come back into frame.
	 * @param now is the Timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
	 */
	@Override
	public void act(long now) {
		super.act(now);
		checkOutOfBounds();
	}

	/**
	 * Used to construct a Turtle object within the game levels.
	 * If turtle is moving in opposite direction, image will be rotated 180 degrees.
	 * @param xpos Sets the initial x position for generated turtle.
	 * @param ypos Sets the initial y position for generated turtle.
	 * @param s Sets the speed for generated Turtle movement.
	 * @param w Sets the width of generated Turtle.
	 * @param h Sets the height of generated Turtle.
	 */
	public Turtle(int xpos, int ypos, int s, int w, int h) {
		super(xpos,ypos,s);
		addHashTurtle(w,h);
		setX(xpos);
		setY(ypos);
		if(s>0) {
			setRotate(180);
		}
	}
	/**
	 * Adds the animation sprite images(in .png format) for turtle movement into a HashMap.
	 * @param w Desired width of  turtle image
	 * @param h Desired height of turtle image
	 */
	public void addHashTurtle(int w,int h){
		for(int animationImages=0;animationImages<=3;animationImages++) {
			TurtleAnimation.put("turtleAnimation"+animationImages, new Image(PLATFORM_RESOURCE_PATH + "TurtleAnimation" + animationImages + ".png", w, h, true, true));
		}
	}

	/**
	 * Plays the Turtle animation through calling the sprites previously added in {@link #addHashTurtle(int, int)} )}.
	 */
	public void playTurtleAnimation(){
		timeline = new Timeline(
				new KeyFrame(Duration.seconds(0), new KeyValue(imageProperty(),TurtleAnimation.get("turtleAnimation1"))),
				new KeyFrame(Duration.seconds(1), new KeyValue(imageProperty(),TurtleAnimation.get("turtleAnimation2"))),
				new KeyFrame(Duration.seconds(2), new KeyValue(imageProperty(),TurtleAnimation.get("turtleAnimation3"))),
				new KeyFrame(Duration.seconds(3), new KeyValue(imageProperty(), null))
		);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}

	/**
	 * Stops the Turtle animation timeline which can be started by {@link #playTurtleAnimation()}
	 */
	public void stopTurtleAnimation(){
		timeline.stop();
	}

	/**
	 * Makes sure Turtle object will always return back into frame after moving out of frame, ensuring it does not permanently go out of bounds.
	 * Manually sets the x-position of Turtle
	 * if the x-coordinate of the Turtle object reaches a certain point, depending on the direction the Turtle is moving.
	 * This method is called in the overriden act method to make sure the application is constantly checking if Turtle is out of bounds.
	 */
	public void checkOutOfBounds(){
		if (getX() > 600 && getSpeed()>0)
			setX(-200);
		if (getX() < -75 && getSpeed()<0)
			setX(600);
	}
}
