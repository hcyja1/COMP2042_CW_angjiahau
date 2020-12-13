package COMP2042_CW_angjiahau.Models.Display;
import static COMP2042_CW_angjiahau.Main.RESOURCE_PATH;


import COMP2042_CW_angjiahau.Controllers.Actor;
import javafx.scene.image.Image;

public class Buttons extends Actor {
	Image startLabel;

	public static final String IMAGE_RESOURCE_PATH = RESOURCE_PATH + "misc/";
	@Override
	public void act(long now) {
		
	}
	
	public Buttons(String imageName,int xpos, int ypos,int wsize, int hsize) {
		setImage(new Image(IMAGE_RESOURCE_PATH + imageName + ".png", wsize, hsize, true, true));
		setX(xpos);
		setY(ypos);
	}
	

}


