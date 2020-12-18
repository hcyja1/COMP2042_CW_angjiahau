package COMP2042_CW_angjiahau.Controllers;
import javafx.scene.image.Image;

public class End extends Actor {
	/**Boolean variable to see if end spot has been reached*/
	boolean activated = false;

	/**
	 * Constructor used to set the x and y coordinate for froggers home(end).
	 * @param x x-coordinate of end
	 * @param y y-coordinate of end
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
	}

	/**
	 * Sets image of frogger reaching home and sets flag {@link #activated} to true.
	 */
	public void setEnd() {
		setImage(new Image("file:src/main/resources/misc/FrogEnd.png", 70, 70, true, true));
		activated = true;
		toFront();
	}

	/**
	 * Getter method.
	 * @return flag value of {@link #activated}
	 */
	public boolean isActivated() {
		return activated;
	}

	/**
	 * Used to reset end points and sets flag {@link #activated} to false.
	 */
	public void reset() {
		activated = false;
		setImage(new Image("file:src/main/resources/misc/End.png", 60, 60, true, true));
		toFront();
	}

	/**
	 * Overriden method which is called in every frame as long as AnimationTimer is active.
	 * @param now is the Timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
	 */
	@Override
	public void act(long now) {
	}


}
