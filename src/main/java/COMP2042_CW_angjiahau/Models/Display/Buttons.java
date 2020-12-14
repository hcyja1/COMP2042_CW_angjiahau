package COMP2042_CW_angjiahau.Models.Display;
import static COMP2042_CW_angjiahau.Main.RESOURCE_PATH;
import COMP2042_CW_angjiahau.Controllers.Actor;
import javafx.scene.image.Image;

public class Buttons extends Actor {
	/** String variable which stores the resource path of buttons*/
	public static final String IMAGE_RESOURCE_PATH = RESOURCE_PATH + "misc/";

	/**
	 * Constructor is used to construct a Button object/image.
	 * @param imageName is the name of the button image file located in {@link #IMAGE_RESOURCE_PATH} in .png format.
	 * @param xpos is the x-position of the button image file.
	 * @param ypos is the y-position of the button image file.
	 * @param wsize is the width of the button image file.
	 * @param hsize is the height of the button image file.
	 */
	public Buttons(String imageName,int xpos, int ypos,int wsize, int hsize) {
		setImage(new Image(IMAGE_RESOURCE_PATH + imageName + ".png", wsize, hsize, true, true));
		setX(xpos);
		setY(ypos);
	}

	/**
	 * Overriden method which is called in every frame as long as AnimationTimer is active.
	 * @param now is the Timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
	 */
	@Override
	public void act(long now) {
	}
}


