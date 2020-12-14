package COMP2042_CW_angjiahau.Models;
import static COMP2042_CW_angjiahau.Main.RESOURCE_PATH;
import COMP2042_CW_angjiahau.Controllers.Actor;
import javafx.scene.image.Image;

public class Obstacle extends Actor {
	/** Private static final String variable which holds the obstacle file path. */
	private static final String OBSTACLE_RESOURCE_PATH = RESOURCE_PATH+"obstacles";
	/** Private final int variable which is used to determine the speed in which the obstacle moves. */
	private final int speed;

	/**
	 * Overriden method which is called in every frame as long as AnimationTimer is active.
	 * This Overriden method makes sure the obstacle is always moving and the obstacle will always come back into frame.
	 * @param now is the Timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		outOfBoundsCheck();
	}

	/**
	 * Used to construct an obstacle object within the game levels.
	 * If speed is negative, meaning the obstacle is moving in opposite direction, the image will be rotated 180 degrees.
	 * Hence there is no need to have two separate sprites for left and right moving obstacle.
	 * @param xpos Sets the initial x-coordinate for the moving obstacle, receives an integer.
	 * @param ypos Sets the initial y-coordinate for the moving obstacle, receives an integer.
	 * @param s Sets the speed for the moving obstacle, receives an integer.
	 * @param w Sets the width of the obstacle constructed, receives an integer.
	 * @param h Sets the height of the obstacle constructed, receives an integer.
	 * @param type Sets the type of obstacle constructed. E.g Truck, Car, RaceCar. Dependant on file name.
	 */
	public Obstacle(int xpos, int ypos, int s, int w, int h, String type) {
		setImage(new Image(OBSTACLE_RESOURCE_PATH+"/"+type+".png", w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed=s;
		if(s<0) {
		setRotate(180);
		}
	}

	/**
	 * Makes sure obstacle will always return back into frame after moving out of frame, ensuring it does not permanently go out of bounds.
	 * Manually sets the x-position of obstacle
	 * if the x-coordinate of the obstacle reaches a certain point, depending on the direction the obstacle is moving.
	 * This method is called in the overriden act method to make sure the application is constantly checking if obstacle is out of bounds.
	 */
	private void outOfBoundsCheck(){
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}
}
