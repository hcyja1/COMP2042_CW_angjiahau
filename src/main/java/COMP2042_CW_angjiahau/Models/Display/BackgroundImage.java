package COMP2042_CW_angjiahau.Models.Display;

import COMP2042_CW_angjiahau.Controllers.Actor;
import javafx.scene.image.Image;
import static COMP2042_CW_angjiahau.Main.RESOURCE_PATH;

public class BackgroundImage extends Actor {
	public static final String IMAGE_RESOURCE_PATH = RESOURCE_PATH + "levels/";
	@Override
	public void act(long now) {
		
		
	}
	
	public BackgroundImage(String imageName) {
		setImage(new Image(IMAGE_RESOURCE_PATH + imageName + ".png", 600, 800, false, false));
		
	}
	
	

}
