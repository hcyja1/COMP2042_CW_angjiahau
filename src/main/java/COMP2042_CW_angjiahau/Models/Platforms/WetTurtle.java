package COMP2042_CW_angjiahau.Models.Platforms;
import javafx.animation.*;
import javafx.scene.image.Image;
import javafx.util.Duration;
import java.util.HashMap;
import static COMP2042_CW_angjiahau.Models.Platforms.Turtle.PLATFORM_RESOURCE_PATH;

public class WetTurtle extends SinkingPlatform {

	/** Hash Map which stores animation for Wet Turtle*/
	HashMap<String,Image> WetTurtleAnimation = new HashMap<>();
	/** Timeline variable for wet turtle movement animation*/
	Timeline timeline;

	/**
	 * Overriden method which is called in every frame as long as AnimationTimer is active.
	 * This Overriden method makes sure the Wet Turtle is always moving and always come back into frame.
	 * @param now is the Timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		outOfBoundsCheck();
	}

	/**
	 * Used to construct a Wet Turtle object within the game levels.
	 * If wet turtle is moving in opposite direction, image will be rotated 180 degrees.
	 * @param xpos Sets the initial x position for generated wet turtle.
	 * @param ypos Sets the initial y position for generated wet turtle.
	 * @param s Sets the speed for generated Wet Turtle movement.
	 * @param w Sets the width of generated Wet Turtle.
	 * @param h Sets the height of generated Wet Turtle.
	 */
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		super(xpos,ypos,s);
		addHashWetTurtle(w,h);
		setX(xpos);
		setY(ypos);
		if(s>0) {
			setRotate(180);
		}
	}

	/**
	 * Adds the animation sprite images(in .png format) for wet turtle movement into a HashMap.
	 * @param w Desired width of wet turtle image
	 * @param h Desired height of wet turtle image
	 */
	public void addHashWetTurtle(int w,int h){
		WetTurtleAnimation.put("Turtle", new Image(PLATFORM_RESOURCE_PATH+ "TurtleAnimation2.png", w, h, true, true));
		for(int animationImages=0;animationImages<=4;animationImages++) {
			WetTurtleAnimation.put("wetturtleAnimation"+animationImages, new Image(PLATFORM_RESOURCE_PATH + "TurtleAnimation" + animationImages + "Wet.png", w, h, true, true));
		}
	}

	/**
	 * Plays the Wet Turtle animation through calling the sprites previously added in {@link #addHashWetTurtle(int, int)}.
	 * setSunk is set to true at the last animation KeyFrame.
	 */
	public void playWetTurtleAnimation(){
		 timeline = new Timeline(
				new KeyFrame(Duration.seconds(0), event -> setSunk(false),new KeyValue(imageProperty(),WetTurtleAnimation.get("Turtle"))),
				new KeyFrame(Duration.seconds(1), new KeyValue(imageProperty(),WetTurtleAnimation.get("wetturtleAnimation2"))),
				new KeyFrame(Duration.seconds(2), new KeyValue(imageProperty(),WetTurtleAnimation.get("wetturtleAnimation3"))),
				new KeyFrame(Duration.seconds(3), event -> setSunk(true),  new KeyValue(imageProperty(),WetTurtleAnimation.get("wetturtleAnimation4"))),
				new KeyFrame(Duration.seconds(4),  new KeyValue(imageProperty(), null))
		);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}

	/**
	 * Stops the Wet Turtle animation timeline which can be started by the {@link #playWetTurtleAnimation()} function.
	 */
	public void stopWetTurtleAnimation(){
		timeline.stop();
	}

	/**
	 * Makes sure Wet Turtle will always return back into frame after moving out of frame, ensuring it does not permanently go out of bounds.
	 * Manually sets the x-position of Wet Turtle
	 * if the x-coordinate of the Wet Turtle reaches a certain point, depending on the direction the Wet Turtle is moving.
	 * This method is called in the overriden act method to make sure the application is constantly checking if Wet Turtle is out of bounds.
	 */
	public void outOfBoundsCheck(){
		if (getX() > 600 && getSpeed()>0)
			setX(-200);
		if (getX() < -75 && getSpeed()<0)
			setX(600);
	}

}

