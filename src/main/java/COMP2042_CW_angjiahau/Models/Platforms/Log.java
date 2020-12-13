package COMP2042_CW_angjiahau.Models.Platforms;

import COMP2042_CW_angjiahau.Models.Platforms.Platform;
import javafx.scene.image.Image;
import static COMP2042_CW_angjiahau.Main.RESOURCE_PATH;

public class Log extends Platform {
	private static final String LOG_RESOURCE_PATH = RESOURCE_PATH+"platforms/log";

	@Override
	public void act(long now) {
		super.act(now);
		if (getX()>600 && getSpeed()>0)
			setX(-180);
		if (getX()<-300 && getSpeed()<0)
			setX(700);
	}
	
	public Log(int size, int xpos, int ypos, double s, int variant) {
		super(xpos,ypos,s);
		setImage(new Image( LOG_RESOURCE_PATH + variant+ ".png", size,size, true, true));
		setX(xpos);
		setY(ypos);
	}

}
