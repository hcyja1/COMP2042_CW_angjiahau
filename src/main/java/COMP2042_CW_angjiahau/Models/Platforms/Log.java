package COMP2042_CW_angjiahau.Models.Platforms;
import javafx.scene.image.Image;
import static COMP2042_CW_angjiahau.Main.RESOURCE_PATH;

public class Log extends Platform {
	/** String variable which holds the resource path for log platform files*/
	private static final String LOG_RESOURCE_PATH = RESOURCE_PATH+"platforms/log";

	/**
	 * Overriden method which is called in every frame as long as AnimationTimer is active.
	 * This Overriden method makes sure the Log object generated is always moving and always come back into frame.
	 * @param now is the Timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
	 */
	@Override
	public void act(long now) {
		super.act(now);
		checkOutOfBounds();
	}

	/**
	 * Used to construct a Log object within the game levels.
	 * If Log is moving in opposite direction, image will be rotated 180 degrees.
	 * @param size Sets the size for generated log object.
	 * @param xpos Sets the initial x position for generated log object.
	 * @param ypos Sets the initial y position for generated log object.
	 * @param s Sets the speedfor generated log object.
	 * @param variant Sets the variant/type of generated log object. String called is based on file name in .png format.
	 */
	public Log(int size, int xpos, int ypos, double s, int variant) {
		super(xpos,ypos,s);
		setImage(new Image( LOG_RESOURCE_PATH + variant+ ".png", size,size, true, true));
		setX(xpos);
		setY(ypos);
		if(s>0) {
			setRotate(180);
		}
	}

	/**
	 * Makes sure Log object will always return back into frame after moving out of frame, ensuring it does not permanently go out of bounds.
	 * Manually sets the x-position of Log
	 * if the x-coordinate of the Log object reaches a certain point, depending on the direction the Log is moving.
	 * This method is called in the overriden act method to make sure the application is constantly checking if Log is out of bounds.
	 */
	public void checkOutOfBounds(){
		if (getX()>600 && getSpeed()>0)
			setX(-180);
		if (getX()<-300 && getSpeed()<0)
			setX(700);
	}
}
