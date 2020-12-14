package COMP2042_CW_angjiahau.Models.Display;
import COMP2042_CW_angjiahau.Controllers.Actor;
import javafx.scene.image.Image;
import static COMP2042_CW_angjiahau.Main.RESOURCE_PATH;

public class BackgroundImage extends Actor {
	/** String variable which stores the resource path of background images*/
	public static final String IMAGE_RESOURCE_PATH = RESOURCE_PATH + "levels/";

	/**
	 * Constructor used to set a background image.
	 * @param imageName is the name of the background image file located in {@link #IMAGE_RESOURCE_PATH} in .png format.
	 */
	public BackgroundImage(String imageName) {
		setImage(new Image(IMAGE_RESOURCE_PATH + imageName + ".png", 600, 800, false, false));
		
	}

	/**
	 * Overriden method which is called in every frame as long as AnimationTimer is active.
	 * @param now is the Timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
	 */
	@Override
	public void act(long now) {
	}


}
