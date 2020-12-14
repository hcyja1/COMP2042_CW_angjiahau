package COMP2042_CW_angjiahau.Models.Display;
import COMP2042_CW_angjiahau.Controllers.Actor;
import javafx.scene.image.Image;
import static COMP2042_CW_angjiahau.Main.RESOURCE_PATH;

public class Digit extends Actor {
	/** Reference variable declaration from {@link Image} package*/
	Image im1;
	/** String variable which stores the resource path of numbers*/
	public static final String NUMBERS_RESOURCE_PATH = RESOURCE_PATH + "/numbers/";

	/**
	 * This constructor is used to construct a Digit object/image.
	 * @param n is the integer of the number image file located within the {@link #NUMBERS_RESOURCE_PATH} in .png format.
	 * @param dim is the size of the number image file constructed.
	 * @param x is the x-position of the number image file.
	 * @param y is the y-position of the number image file.
	 */
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image(NUMBERS_RESOURCE_PATH+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}

	/**
	 * Overriden method which is called in every frame as long as AnimationTimer is active.
	 * @param now is the Timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
	 */
	@Override
	public void act(long now) {

	}

}