package COMP2042_CW_angjiahau;
import static COMP2042_CW_angjiahau.Main.RESOURCE_PATH;


import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.text.Font;

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
	
	public Buttons(String label,int xpos, int ypos) {	
		setX(250);
		setY(400);
	}
}


